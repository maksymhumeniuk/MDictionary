package ua.com.mdictionary.presentationlayer.ui.fragment.lessons.di;

import dagger.Module;
import dagger.Provides;
import ua.com.mdictionary.datalayer.di.scope.PerFragment;
import ua.com.mdictionary.datalayer.preferences.PreferencesManager;
import ua.com.mdictionary.domainlayer.global.repositories.objects.LessonsRepository;
import ua.com.mdictionary.domainlayer.interactor.objects.ObjectsInteractor;
import ua.com.mdictionary.presentationlayer.ui.fragment.lessons.mapper.LessonsMapper;
import ua.com.mdictionary.presentationlayer.ui.fragment.lessons.presenter.LessonsPresenter;

@Module
public class LessonsModule {

    @Provides
    @PerFragment
    LessonsMapper recommendationsMapper() {
        return new LessonsMapper();
    }

    @Provides
    @PerFragment
    ObjectsInteractor recommendationsInteractor(LessonsRepository lessonsRepository) {
        return new ObjectsInteractor(lessonsRepository);
    }

    @Provides
    @PerFragment
    LessonsPresenter recommendationsPresenter(ObjectsInteractor objectsInteractor,
                                              LessonsMapper lessonsMapper,
                                              PreferencesManager preferencesManager) {
        return new LessonsPresenter(objectsInteractor, lessonsMapper, preferencesManager);
    }
}
