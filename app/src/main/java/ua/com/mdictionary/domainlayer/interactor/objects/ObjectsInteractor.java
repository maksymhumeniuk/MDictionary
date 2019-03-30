package ua.com.mdictionary.domainlayer.interactor.objects;

import java.util.List;

import io.reactivex.Single;
import ua.com.mdictionary.datalayer.network.response.LessonsResponse;
import ua.com.mdictionary.domainlayer.global.repositories.objects.LessonsRepository;

public class ObjectsInteractor {

    private LessonsRepository lessonsRepository;

    public ObjectsInteractor(LessonsRepository lessonsRepository) {
        this.lessonsRepository = lessonsRepository;
    }

    public Single<List<LessonsResponse>> getObjects() {
        return lessonsRepository.getObjects();
    }
}
