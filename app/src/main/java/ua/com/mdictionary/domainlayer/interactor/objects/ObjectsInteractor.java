package ua.com.mdictionary.domainlayer.interactor.objects;

import java.util.List;

import io.reactivex.Single;
import ua.com.mdictionary.datalayer.network.response.ObjectResponse;
import ua.com.mdictionary.domainlayer.global.repositories.objects.ObjectsRepository;

public class ObjectsInteractor {

    private ObjectsRepository objectsRepository;

    public ObjectsInteractor(ObjectsRepository objectsRepository) {
        this.objectsRepository = objectsRepository;
    }

    public Single<List<ObjectResponse>> getObjects() {
        return objectsRepository.getObjects();
    }
}
