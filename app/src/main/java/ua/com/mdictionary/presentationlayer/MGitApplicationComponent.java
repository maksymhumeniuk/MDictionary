package ua.com.mdictionary.presentationlayer;

import javax.inject.Singleton;

import dagger.Component;
import ua.com.mdictionary.datalayer.di.ApplicationModule;
import ua.com.mdictionary.datalayer.di.PreferenceModule;
import ua.com.mdictionary.datalayer.di.RepositoryModule;
import ua.com.mdictionary.datalayer.di.RetrofitModule;
import ua.com.mdictionary.presentationlayer.ui.fragment.objects.di.ObjectsModule;
import ua.com.mdictionary.presentationlayer.ui.fragment.objects.di.ObjectsSubcomponent;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        RepositoryModule.class,
        RetrofitModule.class,
        PreferenceModule.class})
public interface MGitApplicationComponent {
    // subcomponents
    ObjectsSubcomponent plus(ObjectsModule objectsModule);
}
