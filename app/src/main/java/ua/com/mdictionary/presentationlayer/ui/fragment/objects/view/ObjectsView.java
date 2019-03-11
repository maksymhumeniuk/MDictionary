package ua.com.mdictionary.presentationlayer.ui.fragment.objects.view;


import ua.com.mdictionary.core.view.BaseView;
import ua.com.mdictionary.presentationlayer.ui.fragment.objects.viewmodel.ObjectViewModel;

public interface ObjectsView extends BaseView {

    void startAddressScreen(ObjectViewModel viewModel);

    /*void changeClickBehavior(boolean isMultiSelect);*/
}
