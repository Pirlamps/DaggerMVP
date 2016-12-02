package br.com.xds.daggerwithrest.application;

import android.app.Application;

import br.com.xds.daggerwithrest.data.component.DaggerNetComponent;
import br.com.xds.daggerwithrest.data.component.NetComponent;
import br.com.xds.daggerwithrest.data.module.AppModule;
import br.com.xds.daggerwithrest.data.module.NetModule;

/**
 * Created by matheus on 02/12/16.
 */

public class App extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();

    }

    public NetComponent getmNetComponent(){
        return this.mNetComponent;
    }
}
