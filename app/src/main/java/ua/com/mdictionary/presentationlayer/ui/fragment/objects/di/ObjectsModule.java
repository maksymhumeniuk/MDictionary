package ua.com.mdictionary.presentationlayer.ui.fragment.objects.di;

import dagger.Module;
import dagger.Provides;
import ua.com.mdictionary.datalayer.di.scope.PerFragment;
import ua.com.mdictionary.datalayer.preferences.PreferencesManager;
import ua.com.mdictionary.domainlayer.global.repositories.objects.ObjectsRepository;
import ua.com.mdictionary.domainlayer.interactor.objects.ObjectsInteractor;
import ua.com.mdictionary.presentationlayer.ui.fragment.objects.mapper.ObjectsMapper;
import ua.com.mdictionary.presentationlayer.ui.fragment.objects.presenter.ObjectsPresenter;

@Module
public class ObjectsModule {

    @Provides
    @PerFragment
    ObjectsMapper recommendationsMapper() {
        return new ObjectsMapper();
    }

    @Provides
    @PerFragment
    ObjectsInteractor recommendationsInteractor(ObjectsRepository objectsRepository) {
        return new ObjectsInteractor(objectsRepository);
    }

    @Provides
    @PerFragment
    ObjectsPresenter recommendationsPresenter(ObjectsInteractor objectsInteractor,
                                              ObjectsMapper objectsMapper,
                                              PreferencesManager preferencesManager) {
        return new ObjectsPresenter(objectsInteractor, objectsMapper, preferencesManager);
    }
}
