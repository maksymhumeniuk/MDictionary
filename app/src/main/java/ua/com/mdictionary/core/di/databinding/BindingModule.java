package ua.com.mdictionary.core.di.databinding;

import dagger.Module;
import dagger.Provides;
import ua.com.mdictionary.core.view.databinding.DataBindingAdapters;
import ua.com.mdictionary.core.view.databinding.DataBindingAdaptersDefault;

@Module
public class BindingModule {
    @Provides
    DataBindingAdapters provideBindingAdapters() {
        return new DataBindingAdaptersDefault();
    }
}
