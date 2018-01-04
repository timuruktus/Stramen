package ru.timuruktus.stramen.di.ApplicationScope;


import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import ru.timuruktus.stramen.presentation.main.presenter.MainPresenter;

@Component(modules = {AppModule.class})
@Singleton
public interface AppComponent{

    void inject(MainPresenter mainPresenter);

}
