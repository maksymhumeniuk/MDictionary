package ua.com.mdictionary.datalayer.repository.objects;


import java.util.List;

import io.reactivex.Single;
import ua.com.mdictionary.datalayer.network.RestApi;
import ua.com.mdictionary.datalayer.network.response.ObjectResponse;
import ua.com.mdictionary.domainlayer.global.repositories.objects.ObjectsRepository;

public class ObjectsRepositoryImpl implements ObjectsRepository {

    private RestApi restApi;

    public ObjectsRepositoryImpl(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Single<List<ObjectResponse>> getObjects() {
        return restApi.getObjects();
    }
}
