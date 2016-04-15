package com.boxfish.ming.dmgame;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.boxfish.ming.dmgame.component.AppComponent;
import com.boxfish.ming.dmgame.component.DaggerAppComponent;
import com.boxfish.ming.dmgame.domain.AnalyticsManager;
import com.boxfish.ming.dmgame.modules.AppModule;
import com.boxfish.ming.dmgame.utils.OttoManager;
import com.boxfish.ming.dmgame.utils.PreferenceU;
import com.boxfish.ming.dmgame.utils.config.KeyMaps;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

// +----------------------------------------------------------------------
// | CreateTime: 16/4/15 
// +----------------------------------------------------------------------
// | Author:     xab(http://www.zhangkun.net.cn)
// +----------------------------------------------------------------------
// | CopyRight:  http://www.boxfish.cn
// +----------------------------------------------------------------------
public class DMgameApplication extends Application {

    private static DMgameApplication instance;

    private Map<String, Activity> activityMap = new HashMap<>();

    private static AppComponent component;
    private static int screenWidth = 0;
    private static int screenHeight = 0;
    private static int contentHeight = 0;

    @Inject
    AnalyticsManager analyticsManager;
    @Inject
    public PreferenceU preferenceU;

    public static DMgameApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        OttoManager.register(this);
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        getComponent().inject(this);
        analyticsManager.registerAppEnter();
    }

    public static void addAty(Activity aty) {
        if (getInstance() == null) return;
        if (aty == null) return;
        if (getInstance().activityMap == null) getInstance().activityMap = new HashMap<>();
        getInstance().activityMap.put(aty.getLocalClassName(), aty);
    }

    private void finishAty(Activity aty) {
        if (aty != null && !aty.isFinishing()) {
            aty.finish();
        }
    }

    public void exit() {
        for (Map.Entry<String, Activity> entry : activityMap.entrySet()) {
            Activity activity = entry.getValue();
            finishAty(activity);
        }
        // TODO: 16/4/15 进行友盟统计
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    public static Context context() {
        return getInstance().getApplicationContext();
    }

    public static AppComponent getComponent() {
        return component;
    }

    public static int getScreenWidth() {
        if (screenWidth == 0) {
            screenWidth = instance.preferenceU.getInt(KeyMaps.screenWidth);
        }
        return screenWidth;
    }

    public static int getScreenHeight() {
        if (screenHeight == 0) {
            screenHeight = instance.preferenceU.getInt(KeyMaps.screenHeight);
        }
        return screenHeight;
    }

    public static int getContentHeight() {
        if (contentHeight == 0) {
            contentHeight = instance.preferenceU.getInt(KeyMaps.contentHeight);
        }
        return contentHeight;
    }

    public static void setContentHeight(int contentHeight) {
        DMgameApplication.contentHeight = contentHeight;
        instance.preferenceU.saveInt(KeyMaps.contentHeight, contentHeight);
    }
}
