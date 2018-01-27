package ru.timuruktus.stramen.di.application_scope;


import javax.inject.Singleton;

import dagger.Component;
import ru.timuruktus.stramen.di.user_scope.UserComponent;
import ru.timuruktus.stramen.di.user_scope.UserModule;
import ru.timuruktus.stramen.presentation.main.MainPresenter;

@Component(modules = {AppModule.class, ApiNetworkModule.class})
@Singleton
public interface AppComponent{

    UserComponent plusUserComponent(UserModule userModule);

    void inject(MainPresenter mainPresenter);

}
