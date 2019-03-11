package ua.com.mdictionary.presentationlayer;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.multidex.MultiDexApplication;

import ua.com.mdictionary.BuildConfig;
import ua.com.mdictionary.core.di.databinding.DaggerBindingComponent;
import ua.com.mdictionary.datalayer.di.ApplicationModule;
import ua.com.mdictionary.datalayer.di.PreferenceModule;
import ua.com.mdictionary.datalayer.di.RepositoryModule;
import ua.com.mdictionary.datalayer.di.RetrofitModule;

public class MGitApplication  extends MultiDexApplication {
    private static MGitApplication instance;
    private MGitApplicationComponent component;

    public static MGitApplicationComponent getComponent(Context context) {
        MGitApplication app = (MGitApplication) context.getApplicationContext();
        if (app.component == null) {
            app.component = DaggerMGitApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(get()))
                    .repositoryModule(new RepositoryModule())
                    .retrofitModule(new RetrofitModule(BuildConfig.API_ENDPOINT))
                    .preferenceModule(new PreferenceModule())
                    .build();
        }
        return app.component;
    }

    public static MGitApplication get() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        DataBindingUtil.setDefaultComponent(DaggerBindingComponent.create());
    }
}
