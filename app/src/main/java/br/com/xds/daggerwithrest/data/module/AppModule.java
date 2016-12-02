package br.com.xds.daggerwithrest.data.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by matheus on 02/12/16.
 */

@Module
public class AppModule {
    Application mApplication;

    public AppModule(Application mApplication){
        this.mApplication = mApplication;
    }

    @Provides
    @Singleton
    Application provideApplication(){
        return mApplication;
    }

}
