package ru.timuruktus.stramen.di.user_scope;


import dagger.Subcomponent;
import ru.timuruktus.stramen.di.scopes.UserScope;
import ru.timuruktus.stramen.presentation.login.presenter.LoginPresenter;

@Subcomponent(modules = {UserModule.class})
@UserScope
public interface UserComponent{

    void inject(LoginPresenter loginPresenter);
}
