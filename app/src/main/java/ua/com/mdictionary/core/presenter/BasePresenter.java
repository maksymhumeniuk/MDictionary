package ua.com.mdictionary.core.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import ua.com.mdictionary.core.view.BaseView;
import ua.com.mdictionary.core.view.viewmodel.ViewModel;

public abstract class BasePresenter<V extends BaseView, VM extends ViewModel> {

    protected volatile V view;

    protected Action showProgress = () -> {
        if (view != null)
            view.showProgress();
    };

    protected Action hideProgress = () -> {
        if (view != null)
            view.hideProgress();
    };
    protected VM viewModel;
    private CompositeDisposable disposables;

    /**
     * Applies view model to the view
     */
    private void applyViewModel() {
        if (view != null) {
            view.setViewModel(view.getViewModelBindingResId(), this.viewModel);
        }
    }

    public VM getViewModel() {
        return viewModel;
    }

    public void setViewModel(VM viewModel) {
        this.viewModel = viewModel;
        applyViewModel();
    }

    public void attachView(V view) {
        this.view = view;
        this.disposables = new CompositeDisposable();
        applyViewModel();
    }

    public void detachView() {
        onDetachView();
        view = null;
        if (disposables != null && !disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    public void onViewAttached(@Nullable Bundle savedInstanceState) {

    }

    public void onDetachView() {
    }

    protected void subscribe(Disposable observable) {
        this.disposables.add(observable);
    }

    protected void onError(Throwable throwable) {
        view.showError(throwable);
    }

}
