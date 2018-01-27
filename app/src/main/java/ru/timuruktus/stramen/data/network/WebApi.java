package ru.timuruktus.stramen.data.network;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import ru.timuruktus.stramen.models.entities.CurrentUser;
import ru.timuruktus.stramen.models.network_entities.Details;
import ru.timuruktus.stramen.models.network_entities.LoginBody;
import ru.timuruktus.stramen.models.network_entities.RegisterBody;
import ru.timuruktus.stramen.models.network_entities.ResetPasswordBody;

public interface WebApi{

    String BASE_URL = "http://62.109.13.137/api/";
    String BASE_URL_OLD_API = BASE_URL + "v01/";

    @POST("clients/auth_jwt/")
    Observable<CurrentUser> authorize(@Body LoginBody body);

    @POST("clients/")
    Observable<CurrentUser> register(@Body RegisterBody body);

    @POST("clients/password/reset/")
    Call<Details> passwordReset(@Body ResetPasswordBody body);

    //TODO Восстановление почты
}
