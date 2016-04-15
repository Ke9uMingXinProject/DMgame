package com.boxfish.ming.dmgame.component;

import com.boxfish.ming.dmgame.component.commons.ActivityScope;
import com.boxfish.ming.dmgame.interactors.MainInteractors;
import com.boxfish.ming.dmgame.modules.MainModule;
import com.boxfish.ming.dmgame.ui.activity.MainActivity;
import com.boxfish.ming.dmgame.ui.features.IMainView;
import com.boxfish.ming.dmgame.ui.presenter.MainPresenter;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = AppComponent.class,
        modules = MainModule.class
)
public interface MainComponent {
    void inject(MainActivity mainActivity);

    IMainView getviewinterface();

    MainPresenter gepresenter();

    MainInteractors getinteractors();

}
