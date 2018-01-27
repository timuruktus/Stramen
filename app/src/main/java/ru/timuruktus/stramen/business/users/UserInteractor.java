package ru.timuruktus.stramen.business.users;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ru.timuruktus.stramen.data.network.WebApi;
import ru.timuruktus.stramen.data.utils.ISettings;
import ru.timuruktus.stramen.models.entities.CurrentUser;
import ru.timuruktus.stramen.models.network_entities.Details;
import ru.timuruktus.stramen.models.network_entities.LoginBody;
import ru.timuruktus.stramen.models.network_entities.RegisterBody;
import ru.timuruktus.stramen.models.network_entities.ResetPasswordBody;
import ru.timuruktus.stramen.repositories.user.IUserRepository;

import static ru.timuruktus.stramen.presentation.main.MainActivity.TESTING_TAG;

public class UserInteractor implements IUserInteractor{


    WebApi webApi; //needs to be injected
    IUserRepository userRepository; //needs to be injected
    ISettings settings;

    @Inject
    public UserInteractor(WebApi webApi, IUserRepository userRepository, ISettings settings){
        this.webApi = webApi;
        this.userRepository = userRepository;
        this.settings = settings;
    }

    @Override
    public Observable<CurrentUser> loginUser(String email, String password){
        LoginBody body = new LoginBody(email, password);
        return webApi.authorize(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(currentUser -> {
            userRepository.saveCurrentUser(currentUser);
            settings.setFirstOpen(false); //TODO
            return currentUser;
        });
    }

    @Override
    public Observable<CurrentUser> registerUser(String email, String username, String password){
        RegisterBody body = new RegisterBody();
        body.setEmail(email);
        body.setUsername(username);
        body.setPassword1(password);
        body.setPassword2(password);
        return webApi.register(body).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(currentUser -> {
                    userRepository.saveCurrentUser(currentUser);
                    settings.setFirstOpen(false); //TODO
                    return currentUser;
                });
    }

    @Override
    public void resetPassword(String email){
        ResetPasswordBody body = new ResetPasswordBody(email);
        webApi.passwordReset(body).enqueue(new Callback<Details>(){
            @Override
            public void onResponse(Call<Details> call, Response<Details> response){

            }

            @Override
            public void onFailure(Call<Details> call, Throwable t){

            }
        });
    }




}
