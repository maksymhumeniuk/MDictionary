package ua.com.mdictionary.datalayer.di;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.com.mdictionary.datalayer.preferences.PreferencesManager;


@Module
public class PreferenceModule {

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application.getApplicationContext());
    }

    @Provides
    @Singleton
    PreferencesManager providePreferenceManager(SharedPreferences sharedPreferences) {
        return new PreferencesManager(sharedPreferences);
    }
}
