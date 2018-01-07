package ru.timuruktus.stramen.di.application_scope;


import javax.inject.Singleton;

import dagger.Component;
import ru.timuruktus.stramen.presentation.login.view.LoginFragment;
import ru.timuruktus.stramen.presentation.main.presenter.MainPresenter;

@Component(modules = {AppModule.class, ApiNetworkModule.class})
@Singleton
public interface AppComponent{

    void inject(MainPresenter mainPresenter);
    void inject(LoginFragment loginFragment);

}
