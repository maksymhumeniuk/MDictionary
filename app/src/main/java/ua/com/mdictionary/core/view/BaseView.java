package ua.com.mdictionary.core.view;


import ua.com.mdictionary.core.view.message.UiMessage;

public interface BaseView {

    /**
     * Method for retrieving viewModel layout BR (binding resource) variable
     *
     * @return viewModel layout BR
     */
    int getViewModelBindingResId();

    /**
     * Applies viewModel to the layout through dataBinding
     *
     * @param viewModelBindingResId viewModel BR variable
     * @param viewModel             viewModel to set
     */
    void setViewModel(int viewModelBindingResId, Object viewModel);

    void showProgress();

    void hideProgress();

    void showMessage(String message);

    void showMessage(int stringResId, Object... args);

    void showMessage(UiMessage message, Object... args);

    void showError(Throwable throwable);

    void hideSoftKeyboard();

    void performBackAction();

    boolean isNetworkConnected(boolean showMessage);
}
