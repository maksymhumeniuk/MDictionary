package ua.com.mdictionary.core.view;


import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Objects;

import javax.inject.Inject;

import ua.com.mdictionary.core.presenter.BasePresenter;
import ua.com.mdictionary.core.view.message.UiMessage;
import ua.com.mdictionary.core.view.utils.UiUtils;


public abstract class BaseFragment<P extends BasePresenter, B extends ViewDataBinding> extends Fragment implements BaseView {

    @Inject
    protected P presenter;
    protected B binding;

    protected abstract int getLayoutId();

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.inject();
    }

    @SuppressWarnings("unchecked")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        this.presenter.attachView(this);
        this.onCreateView(savedInstanceState);
        return this.binding.getRoot();
    }

    public abstract void onCreateView(Bundle savedInstanceState);

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.onViewAttached(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

    @Override
    public void setViewModel(int viewModelBindingResId, Object viewModel) {
        binding.setVariable(viewModelBindingResId, viewModel);
    }

    public abstract void inject();

    @Override
    public void showProgress() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).showProgress();
        }
    }

    @Override
    public void hideProgress() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).hideProgress();
        }
    }

    @Override
    public void showMessage(String message) {
        final ViewGroup viewGroup = (ViewGroup) ((ViewGroup) getActivity().findViewById(android.R.id.content)).getChildAt(0);
        UiUtils.showMessage(message, viewGroup);
    }

    @Override
    public void showMessage(int resId, Object... args) {
        Resources res = getResources();
        String message = String.format(res.getString(resId), args);
        showMessage(message);
    }

    @Override
    public void showMessage(UiMessage message, Object... args) {
        showMessage(message.getMessageResId(), args);
    }

    @Override
    public void showError(Throwable throwable) {
        // TODO implement error handler
        showMessage(throwable.getMessage());
    }

    @Override
    public void hideSoftKeyboard() {
        UiUtils.hideSoftKeyboard(this.getActivity());
    }

    @Override
    public void performBackAction() {
        Objects.requireNonNull(getActivity()).onBackPressed();
    }

    public boolean checkPermission(String[] permissions, int resultCode) {
        if (Build.VERSION.SDK_INT >= 23 && !isPermissionsAvailable(permissions)) {
            requestPermissions(permissions, resultCode);
            return false;
        }
        return true;
    }

    private boolean isPermissionsAvailable(String[] permissions) {
        for (String permission : permissions)
            if (ContextCompat.checkSelfPermission(getActivity(), permission) != PackageManager.PERMISSION_GRANTED)
                return false;
        return true;
    }

    @Override
    public boolean isNetworkConnected(boolean showMessage) {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            return (netInfo != null && netInfo.isConnected());
        }

        return false;
    }
}
