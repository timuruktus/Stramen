package ru.timuruktus.stramen.di.application_scope;

import javax.inject.Singleton;

import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.timuruktus.stramen.data.network.WebApi;

import static ru.timuruktus.stramen.data.network.WebApi.BASE_URL_OLD_API;

public class ApiNetworkModule{


    @Provides
    @Singleton
    WebApi provideWebApi(){
        Retrofit webRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_OLD_API)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return webRetrofit.create(WebApi.class);
    }




}
