package ua.com.mdictionary.core.view;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import ua.com.mdictionary.R;


public abstract class BaseActivity<B extends ViewDataBinding> extends AppCompatActivity {

    protected B binding;
    private ProgressDialog progress;
    private short progressCounter;

    public static void startActivityAsRoot(Activity prevActivity, Intent intent) {
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        prevActivity.startActivity(intent);
        ActivityCompat.finishAffinity(prevActivity);
    }

    public abstract int getLayoutId();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());
    }

    public void setToolbarTitle(String title) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(title);
        }
    }

    public void replaceFragment(Fragment fragment, int containerId, boolean addToBackStack) {
        String tag = fragment.getClass().getName();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction = transaction.replace(containerId, fragment, tag);
        if (addToBackStack) transaction = transaction.addToBackStack(tag);
        transaction.commit();
    }

    public void showProgress() {
        progressCounter++;
        runOnUiThread(() -> {
            if (progress == null) {
                progress = new ProgressDialog(this);
                progress.setOnCancelListener(dialogInterface -> progressCounter = 0);
                progress.setCancelable(true);
                progress.setMessage(getString(R.string.message_loading));
            }
            if (!progress.isShowing()) {
                progress.show();
            }
        });
    }

    public void hideProgress() {
        if (progressCounter > 0) progressCounter--;
        runOnUiThread(() -> {
            if (progress != null && progress.isShowing() && progressCounter <= 0) {
                progress.dismiss();
            }
        });
    }

}
