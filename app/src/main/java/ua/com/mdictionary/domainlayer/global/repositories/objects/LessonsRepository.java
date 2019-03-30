package ua.com.mdictionary.domainlayer.global.repositories.objects;

import java.util.List;

import io.reactivex.Single;
import ua.com.mdictionary.datalayer.network.response.LessonsResponse;

public interface LessonsRepository {

    Single<List<LessonsResponse>> getObjects();

}
