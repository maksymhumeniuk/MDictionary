package ua.com.mdictionary.presentationlayer.ui.activity;

import android.os.Bundle;

import ua.com.mdictionary.R;
import ua.com.mdictionary.core.view.BaseActivity;
import ua.com.mdictionary.databinding.ActivityMainBinding;
import ua.com.mdictionary.presentationlayer.ui.fragment.lessons.view.LessonsFragment;


public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding.bottomNavigation.setSelectedItemId(R.id.action_dictionary);

        //setSupportActionBar(binding.toolbar);
        setToolbarTitle(null);
        replaceFragment(LessonsFragment.newInstance(), R.id.container, false);
    }
}
