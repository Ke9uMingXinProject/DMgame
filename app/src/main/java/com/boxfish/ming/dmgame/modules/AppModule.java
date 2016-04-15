// +----------------------------------------------------------------------
// | FileName:   ${file_name}
// +----------------------------------------------------------------------
// | CreateTime: ${date}  ${time}
// +----------------------------------------------------------------------
// | Author:     xab(admin@xueyong.net.cn)
// +----------------------------------------------------------------------
// | Description:
// +----------------------------------------------------------------------


package com.boxfish.ming.dmgame.modules;

import android.app.Application;

import com.boxfish.ming.dmgame.DMgameApplication;
import com.boxfish.ming.dmgame.utils.PreferenceU;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private final DMgameApplication app;

    public AppModule(DMgameApplication app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    PreferenceU providePreferenceU() {
        return PreferenceU.getInstance(app.getApplicationContext());
    }

}
