package ua.com.mdictionary.datalayer.repository.objects;


import java.util.List;

import io.reactivex.Single;
import ua.com.mdictionary.datalayer.network.RestApi;
import ua.com.mdictionary.datalayer.network.response.LessonsResponse;
import ua.com.mdictionary.domainlayer.global.repositories.objects.LessonsRepository;

public class LessonsRepositoryImpl implements LessonsRepository {

    private RestApi restApi;

    public LessonsRepositoryImpl(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Single<List<LessonsResponse>> getObjects() {
        return restApi.getObjects();
    }
}
