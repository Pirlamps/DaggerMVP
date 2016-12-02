package br.com.xds.daggerwithrest.main_activity;

import javax.inject.Scope;
import javax.inject.Singleton;

import br.com.xds.daggerwithrest.util.CustomScope;
import dagger.Module;
import dagger.Provides;
import rx.android.MainThreadSubscription;

/**
 * Created by matheus on 02/12/16.
 */

@Module
public class MainActivityModule {

    private final MainActivityContract.View mView;

    public MainActivityModule(MainActivityContract.View mView){
        this.mView = mView;
    }

    @Provides
    @CustomScope
    MainActivityContract.View provideMainActivityContractView(){
        return mView;
    }
}
