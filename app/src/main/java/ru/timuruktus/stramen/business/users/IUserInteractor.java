package ru.timuruktus.stramen.business.users;

import io.reactivex.Observable;
import ru.timuruktus.stramen.models.entities.CurrentUser;

public interface IUserInteractor{

    Observable<CurrentUser> loginUser(String email, String password);

    Observable<CurrentUser> registerUser(String email, String username, String password);

    void resetPassword(String email);
}
