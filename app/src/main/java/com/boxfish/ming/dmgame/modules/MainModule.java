package com.boxfish.ming.dmgame.modules;

import com.boxfish.ming.dmgame.interactors.MainInteractors;
import com.boxfish.ming.dmgame.ui.features.IMainView;
import com.boxfish.ming.dmgame.ui.presenter.MainPresenter;
import com.boxfish.ming.dmgame.ui.presenterimp.MainPresenterImp;

import dagger.Module;
import dagger.Provides;

// +----------------------------------------------------------------------
// | CreateTime: 16/4/15 
// +----------------------------------------------------------------------
// | Author:     xab(http://www.zhangkun.net.cn)
// +----------------------------------------------------------------------
// | CopyRight:  http://www.boxfish.cn
// +----------------------------------------------------------------------
@Module
public class MainModule {

    private IMainView viewInterface;

    public MainModule(IMainView viewInterface) {
        this.viewInterface = viewInterface;
    }

    @Provides
    public IMainView provideiewInterface() {
        return viewInterface;
    }

    @Provides
    public MainPresenter getRegisterPresenter(IMainView viewInterface, MainInteractors Interactors) {
        return new MainPresenterImp(viewInterface, Interactors);
    }

    @Provides
    public MainInteractors provideInteractors() {
        return new MainInteractors();
    }
}
