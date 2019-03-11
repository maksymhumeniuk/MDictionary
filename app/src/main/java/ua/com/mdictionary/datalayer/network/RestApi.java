package ua.com.mdictionary.datalayer.network;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import ua.com.mdictionary.datalayer.network.response.ObjectResponse;

public interface RestApi {

    @GET("ws/objectsList")
    public Single<List<ObjectResponse>> getObjects();

}
