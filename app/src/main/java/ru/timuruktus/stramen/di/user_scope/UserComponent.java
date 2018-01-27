package ru.timuruktus.stramen.di.user_scope;


import dagger.Subcomponent;
import ru.timuruktus.stramen.di.scopes.UserScope;
import ru.timuruktus.stramen.presentation.login.LoginPresenter;
import ru.timuruktus.stramen.presentation.registration.RegistrationPresenter;

@Subcomponent(modules = {UserModule.class})
@UserScope
public interface UserComponent{

    void inject(LoginPresenter loginPresenter);
    void inject(RegistrationPresenter registrationPresenter);
}
