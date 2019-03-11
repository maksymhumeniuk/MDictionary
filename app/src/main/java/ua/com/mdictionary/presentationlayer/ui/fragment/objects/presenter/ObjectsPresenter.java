package ua.com.mdictionary.presentationlayer.ui.fragment.objects.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.Set;

import ua.com.mdictionary.core.presenter.BasePresenter;
import ua.com.mdictionary.core.utils.transformers.SingleRxTransformers;
import ua.com.mdictionary.datalayer.preferences.PreferencesManager;
import ua.com.mdictionary.domainlayer.interactor.objects.ObjectsInteractor;
import ua.com.mdictionary.presentationlayer.ui.fragment.objects.mapper.ObjectsMapper;
import ua.com.mdictionary.presentationlayer.ui.fragment.objects.view.ObjectsView;
import ua.com.mdictionary.presentationlayer.ui.fragment.objects.view.adapter.ObjectItem;
import ua.com.mdictionary.presentationlayer.ui.fragment.objects.viewmodel.ObjectsScreenViewModel;

public class ObjectsPresenter extends BasePresenter<ObjectsView, ObjectsScreenViewModel> {

    private ObjectsInteractor objectsInteractor;
    private ObjectsMapper mapper;
    private PreferencesManager preferencesManager;

    public ObjectsPresenter(ObjectsInteractor objectsInteractor,
                            ObjectsMapper objectsMapper,
                            PreferencesManager preferencesManager) {
        mapper = objectsMapper;
        this.objectsInteractor = objectsInteractor;
        this.preferencesManager = preferencesManager;
        setViewModel(new ObjectsScreenViewModel());
    }

    @Override
    public void onViewAttached(@Nullable Bundle savedInstanceState) {
        super.onViewAttached(savedInstanceState);
        Set<String> selectedIds = preferencesManager.getSelectedIds();
        getObjects(selectedIds);
    }

    private void getObjects(Set<String> selectedIds) {
        subscribe(objectsInteractor.getObjects()
                .compose(SingleRxTransformers.applyApiRequestSchedulers())
                .compose(SingleRxTransformers.applyOnBeforeAndAfter(showProgress, hideProgress))
                .subscribe(objectsResponse ->
                                viewModel.objects.addAll(mapper.mapObjects(objectsResponse, selectedIds)),
                        this::onError));
    }

    public void onObjectClick(ObjectItem objectItem, boolean isMultiSelect) {
        if (isMultiSelect) {
            if (objectItem.getViewModel().isItemSelected()) {
                objectItem.getViewModel().setItemSelected(false);
                preferencesManager.removeUnselectedId(objectItem.getViewModel().getId());
            } else {
                objectItem.getViewModel().setItemSelected(true);
                preferencesManager.saveSelectedId(objectItem.getViewModel().getId());
            }
        } else {
            view.startAddressScreen(objectItem.getViewModel());
        }
    }

    /*public void onObjectLongClick(ObjectItem objectItem) {
        objectItem.getViewModel().setItemSelected(true);
        preferencesManager.saveSelectedId(objectItem.getViewModel().getId());
        view.changeClickBehavior(true);
    }*/

    public void onCancelMultiSelectClick() {
        preferencesManager.clearSelectedIds();
    }
}
