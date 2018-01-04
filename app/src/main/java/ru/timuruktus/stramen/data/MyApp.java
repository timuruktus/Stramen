package ru.timuruktus.stramen.data;

import android.app.Application;
import android.content.Context;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.timuruktus.stramen.R;
import ru.timuruktus.stramen.di.ApplicationScope.AppComponent;
import ru.timuruktus.stramen.di.ApplicationScope.AppModule;
import ru.timuruktus.stramen.di.ApplicationScope.DaggerAppComponent;


public class MyApp extends Application{

    AppComponent appComponent;
    public static MyApp INSTANCE;
    private Cicerone<Router> cicerone;

    @Override
    public void onCreate(){
        super.onCreate();
        INSTANCE = this;
        cicerone = Cicerone.create();
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent(){
        return appComponent;
    }

    public NavigatorHolder getNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }

    public Router getRouter() {
        return cicerone.getRouter();
    }

}
