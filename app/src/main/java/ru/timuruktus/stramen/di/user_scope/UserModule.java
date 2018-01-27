package ru.timuruktus.stramen.di.user_scope;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.timuruktus.stramen.business.users.IUserInteractor;
import ru.timuruktus.stramen.business.users.UserInteractor;
import ru.timuruktus.stramen.data.network.WebApi;
import ru.timuruktus.stramen.data.utils.ISettings;
import ru.timuruktus.stramen.repositories.user.UserRepository;

@Module
public class UserModule{

    @Provides
    IUserInteractor provideInteractor(WebApi webApi, UserRepository userRepository, ISettings settings){
        return new UserInteractor(webApi, userRepository, settings);
    }

    @Provides
    UserRepository provideRepository(){
        return new UserRepository();
    }
}
