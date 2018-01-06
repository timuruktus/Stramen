package ru.timuruktus.stramen.di.ApplicationScope;


import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.timuruktus.stramen.data.Utils.IMetricUtils;
import ru.timuruktus.stramen.data.Utils.ISettings;
import ru.timuruktus.stramen.data.Utils.MetricUtils;
import ru.timuruktus.stramen.data.Utils.Settings;

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
    IMetricUtils provideMetricUtils(){
        return new MetricUtils(context);
    }
}
