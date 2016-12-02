package br.com.xds.daggerwithrest.data.component;

import javax.inject.Singleton;

import br.com.xds.daggerwithrest.data.module.AppModule;
import br.com.xds.daggerwithrest.data.module.NetModule;
import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by matheus on 02/12/16.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
}
