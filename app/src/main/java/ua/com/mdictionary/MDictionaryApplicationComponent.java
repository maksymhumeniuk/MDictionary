package ua.com.mdictionary;

import javax.inject.Singleton;

import dagger.Component;
import ua.com.mdictionary.datalayer.di.ApplicationModule;
import ua.com.mdictionary.datalayer.di.PreferenceModule;
import ua.com.mdictionary.datalayer.di.RepositoryModule;
import ua.com.mdictionary.datalayer.di.RetrofitModule;
import ua.com.mdictionary.presentationlayer.ui.fragment.lessons.di.LessonsModule;
import ua.com.mdictionary.presentationlayer.ui.fragment.lessons.di.LessonsSubcomponent;

@Singleton
@Component(modules = {
        ApplicationModule.class,
        RepositoryModule.class,
        RetrofitModule.class,
        PreferenceModule.class})
public interface MDictionaryApplicationComponent {
    // subcomponents
    LessonsSubcomponent plus(LessonsModule lessonsModule);
}
