package ua.com.mdictionary.datalayer.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ua.com.mdictionary.datalayer.network.RestApi;
import ua.com.mdictionary.datalayer.repository.objects.LessonsRepositoryImpl;
import ua.com.mdictionary.domainlayer.global.repositories.objects.LessonsRepository;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    LessonsRepository recommendationsRepository(RestApi restApi) {
        return new LessonsRepositoryImpl(restApi);
    }
}
