package ua.com.mdictionary.presentationlayer.ui.fragment.lessons.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.Objects;

import ua.com.mdictionary.BR;
import ua.com.mdictionary.MDictionaryApplication;
import ua.com.mdictionary.R;
import ua.com.mdictionary.core.view.BaseFragment;
import ua.com.mdictionary.databinding.FragmentLessonsBinding;
import ua.com.mdictionary.presentationlayer.ui.fragment.lessons.di.LessonsModule;
import ua.com.mdictionary.presentationlayer.ui.fragment.lessons.presenter.LessonsPresenter;
import ua.com.mdictionary.presentationlayer.ui.fragment.lessons.view.adapter.LessonsAdapter;
import ua.com.mdictionary.presentationlayer.ui.fragment.lessons.viewmodel.LessonsViewModel;

public class LessonsFragment extends BaseFragment<LessonsPresenter, FragmentLessonsBinding>
        implements LessonsView {

    private LessonsAdapter adapter;

    public static Fragment newInstance() {

        Bundle args = new Bundle();
        LessonsFragment fragment = new LessonsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getViewModelBindingResId() {
        return BR.viewModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_lessons;
    }

    @Override
    public void onCreateView(Bundle savedInstanceState) {
        /* binding.setPresenter(presenter);*/
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new LessonsAdapter();
        binding.listRecommendations.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.listRecommendations.setAdapter(adapter);
    }

    @Override
    public void inject() {
        MDictionaryApplication.getComponent(Objects.requireNonNull(getActivity()))
                .plus(new LessonsModule())
                .inject(this);
    }

    @Override
    public void startAddressScreen(LessonsViewModel viewModel) {

    }

    /*@Override
    public void changeClickBehavior(boolean isMultiSelect) {
        adapter.setOnItemClickListener(item -> presenter.onObjectClick(item, isMultiSelect));
    }*/
}
