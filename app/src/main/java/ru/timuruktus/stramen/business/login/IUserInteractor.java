package ru.timuruktus.stramen.business.login;

import io.reactivex.Observable;
import ru.timuruktus.stramen.models.users.CurrentUser;

public interface IUserInteractor{

    Observable<CurrentUser> loginUser(String email, String password);
}
