package ua.com.mdictionary.core.view.message;


import ua.com.mdictionary.R;

public enum ErrorType implements UiMessage {

    EMPTY_FIELDS(R.string.error_empty_fields),
    NO_INTERNET_CONNECTION(R.string.error_no_internet_connection);


    private int messageResId;

    ErrorType(int errorMessageResId) {
        this.messageResId = errorMessageResId;
    }

    @Override
    public int getMessageResId() {
        return messageResId;
    }

}
