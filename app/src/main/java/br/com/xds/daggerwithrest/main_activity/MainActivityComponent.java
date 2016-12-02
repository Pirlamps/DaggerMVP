package br.com.xds.daggerwithrest.main_activity;

import br.com.xds.daggerwithrest.data.component.NetComponent;
import br.com.xds.daggerwithrest.util.CustomScope;
import dagger.Component;

/**
 * Created by matheus on 02/12/16.
 */

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainActivityModule.class)
public interface MainActivityComponent {
    void inject(MainActivity activity);
}
