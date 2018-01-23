package ru.timuruktus.stramen.business.users;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import ru.timuruktus.stramen.data.network.WebApi;
import ru.timuruktus.stramen.models.entities.CurrentUser;
import ru.timuruktus.stramen.repositories.user.UserRepository;

public class UserInteractor implements IUserInteractor{


    @Inject
    WebApi webApi; //needs to be injected
    @Inject
    UserRepository userRepository; //needs to be injected

    @Override
    public Observable<CurrentUser> loginUser(String email, String password){
        Map<String, String> body = new HashMap<>();
        body.put("email", email);
        body.put("password", password);
        return webApi.authorize(body).map(currentUser -> {
            userRepository.saveCurrentUser(currentUser);
            return currentUser;
        });
    }
}
