package ru.timuruktus.stramen.business.login;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import ru.timuruktus.stramen.data.network.WebApi;
import ru.timuruktus.stramen.models.users.CurrentUser;
import ru.timuruktus.stramen.repositories.user.UserRepository;

public class UserInteractor implements IUserInteractor{


    WebApi webApi;
    UserRepository userRepository;

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
