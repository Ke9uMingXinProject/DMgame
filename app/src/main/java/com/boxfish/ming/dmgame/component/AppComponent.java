package com.boxfish.ming.dmgame.component;

import com.boxfish.ming.dmgame.DMgameApplication;
import com.boxfish.ming.dmgame.modules.AppModule;
import com.boxfish.ming.dmgame.modules.DomainModule;
import com.boxfish.ming.dmgame.utils.PreferenceU;

import javax.inject.Singleton;

import dagger.Component;

// +----------------------------------------------------------------------
// | CreateTime: 16/4/15 
// +----------------------------------------------------------------------
// | Author:     xab(http://www.zhangkun.net.cn)
// +----------------------------------------------------------------------
// | CopyRight:  http://www.boxfish.cn
// +----------------------------------------------------------------------
@Singleton
@Component(modules = {
        AppModule.class,
        DomainModule.class
})
public interface AppComponent {
    void inject(DMgameApplication instance);
    PreferenceU getpu();
}
