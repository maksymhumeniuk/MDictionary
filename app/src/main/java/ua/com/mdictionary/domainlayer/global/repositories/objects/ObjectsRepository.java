package ua.com.mdictionary.domainlayer.global.repositories.objects;

import java.util.List;

import io.reactivex.Single;
import ua.com.mdictionary.datalayer.network.response.ObjectResponse;

public interface ObjectsRepository {

    Single<List<ObjectResponse>> getObjects();

}
