package ru.timuruktus.stramen.di.user_scope;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.timuruktus.stramen.business.users.IUserInteractor;
import ru.timuruktus.stramen.business.users.UserInteractor;
import ru.timuruktus.stramen.data.network.WebApi;
import ru.timuruktus.stramen.repositories.user.UserRepository;

@Module
public class UserModule{

    @Provides
    IUserInteractor provideInteractor(WebApi webApi, UserRepository userRepository){
        return new UserInteractor(webApi, userRepository);
    }

    @Provides
    UserRepository provideRepository(){
        return new UserRepository();
    }
}
