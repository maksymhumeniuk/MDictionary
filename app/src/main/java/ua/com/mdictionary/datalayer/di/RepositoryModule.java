package ua.com.mdictionary.datalayer.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.com.mdictionary.datalayer.network.RestApi;
import ua.com.mdictionary.datalayer.repository.objects.ObjectsRepositoryImpl;
import ua.com.mdictionary.domainlayer.global.repositories.objects.ObjectsRepository;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    ObjectsRepository recommendationsRepository(RestApi restApi) {
        return new ObjectsRepositoryImpl(restApi);
    }
}
