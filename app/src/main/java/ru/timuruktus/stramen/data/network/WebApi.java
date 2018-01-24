package ru.timuruktus.stramen.data.network;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import ru.timuruktus.stramen.models.entities.CurrentUser;

public interface WebApi{

    String BASE_URL = "http://62.109.13.137/api/";
    String BASE_URL_OLD_API = BASE_URL + "v01/";

    @FormUrlEncoded
    @POST("clients/auth_jwt/")
    Observable<CurrentUser> authorize(@FieldMap Map<String, String> params);

    //TODO Восстановление почты
}
