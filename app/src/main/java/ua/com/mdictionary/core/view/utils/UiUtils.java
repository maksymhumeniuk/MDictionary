package ua.com.mdictionary.core.view.utils;


import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public final class UiUtils {

    private UiUtils() {
    }

    /**
     * Shows message with snackBar
     */
    public static void showMessage(String message, View view) {
        if (!TextUtils.isEmpty(message) && view != null) {
            Snackbar snackbar = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }

    public static void hideSoftKeyboard(Activity activity) {
        if (activity != null) {
            View view = activity.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
            }
        }
    }

    /**
     * Shows dialog with positive and negative custom actions
     */
    public static AlertDialog buildConfirmationDialog(Context context, CharSequence title, CharSequence message,
                                                      String positiveTitle, Runnable positiveAction,
                                                      String negativeTitle, Runnable negativeAction,
                                                      boolean cancelable) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(cancelable)
                .setNegativeButton(negativeTitle, (dialog, which) -> {
                    if (negativeAction != null) {
                        negativeAction.run();
                    }
                })
                .setPositiveButton(positiveTitle, (dialog, which) -> {
                    if (positiveAction != null) {
                        positiveAction.run();
                    }
                });
        return builder.create();
    }
}
