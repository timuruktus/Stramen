package ru.timuruktus.stramen.di.application_scope;


import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.timuruktus.stramen.data.utils.IDataConverter;
import ru.timuruktus.stramen.data.utils.ISettings;
import ru.timuruktus.stramen.data.utils.DataConverter;
import ru.timuruktus.stramen.data.utils.Settings;

@Module
public class AppModule{

    private Context context;

    public AppModule(@NonNull Context context){
        this.context = context;
    }

    @Provides
    @Singleton
    Context provideContext(){
        return context;
    }

    @Provides
    @Singleton
    ISettings provideSettings(){
        return new Settings(context);
    }

    @Provides
    @Singleton
    IDataConverter provideDataConverter(){
        return new DataConverter(context);
    }
}
