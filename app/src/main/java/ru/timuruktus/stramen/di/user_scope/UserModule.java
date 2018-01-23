package ru.timuruktus.stramen.di.user_scope;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Provides;
import ru.timuruktus.stramen.business.users.IUserInteractor;
import ru.timuruktus.stramen.business.users.UserInteractor;
import ru.timuruktus.stramen.repositories.user.UserRepository;

public class UserModule{

    @Provides
    IUserInteractor provideInteractor(){
        return new UserInteractor();
    }

    @Provides
    UserRepository provideRepository(){
        return new UserRepository();
    }
}
