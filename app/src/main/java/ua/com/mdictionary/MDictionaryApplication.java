package ua.com.mdictionary;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.multidex.MultiDexApplication;

import ua.com.mdictionary.core.di.databinding.DaggerBindingComponent;
import ua.com.mdictionary.datalayer.di.ApplicationModule;
import ua.com.mdictionary.datalayer.di.PreferenceModule;
import ua.com.mdictionary.datalayer.di.RepositoryModule;
import ua.com.mdictionary.datalayer.di.RetrofitModule;

public class MDictionaryApplication extends MultiDexApplication {
    private static MDictionaryApplication instance;
    private MDictionaryApplicationComponent component;

    public static MDictionaryApplicationComponent getComponent(Context context) {
        MDictionaryApplication app = (MDictionaryApplication) context.getApplicationContext();
        if (app.component == null) {
            app.component = DaggerMDictionaryApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(get()))
                    .repositoryModule(new RepositoryModule())
                    .retrofitModule(new RetrofitModule(BuildConfig.API_ENDPOINT))
                    .preferenceModule(new PreferenceModule())
                    .build();
        }
        return app.component;
    }

    public static MDictionaryApplication get() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        DataBindingUtil.setDefaultComponent(DaggerBindingComponent.create());
    }
}
