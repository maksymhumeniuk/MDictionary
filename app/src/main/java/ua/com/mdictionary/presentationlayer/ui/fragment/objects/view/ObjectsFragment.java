package ua.com.mdictionary.presentationlayer.ui.fragment.objects.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import java.util.Objects;

import ua.com.mdictionary.BR;
import ua.com.mdictionary.R;
import ua.com.mdictionary.core.view.BaseFragment;
import ua.com.mdictionary.databinding.FragmentObjectsBinding;
import ua.com.mdictionary.presentationlayer.MGitApplication;
import ua.com.mdictionary.presentationlayer.ui.fragment.objects.di.ObjectsModule;
import ua.com.mdictionary.presentationlayer.ui.fragment.objects.presenter.ObjectsPresenter;
import ua.com.mdictionary.presentationlayer.ui.fragment.objects.view.adapter.ObjectsAdapter;
import ua.com.mdictionary.presentationlayer.ui.fragment.objects.viewmodel.ObjectViewModel;

public class ObjectsFragment extends BaseFragment<ObjectsPresenter, FragmentObjectsBinding>
        implements ObjectsView {

    private ObjectsAdapter adapter;

    public static Fragment newInstance() {

        Bundle args = new Bundle();

        ObjectsFragment fragment = new ObjectsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getViewModelBindingResId() {
        return BR.viewModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_objects;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
       /* binding.setPresenter(presenter);*/
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new ObjectsAdapter();
        /*adapter.setOnLongClickListener(presenter::onObjectLongClick);*/
        //changeClickBehavior(false);
       /* binding.listRecommendations.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.listRecommendations.setAdapter(adapter);*/
    }

    @Override
    public void inject() {
        MGitApplication.getComponent(Objects.requireNonNull(getActivity()))
                .plus(new ObjectsModule())
                .inject(this);
    }

    @Override
    public void startAddressScreen(ObjectViewModel viewModel) {

    }

    /*@Override
    public void changeClickBehavior(boolean isMultiSelect) {
        adapter.setOnItemClickListener(item -> presenter.onObjectClick(item, isMultiSelect));
    }*/
}
