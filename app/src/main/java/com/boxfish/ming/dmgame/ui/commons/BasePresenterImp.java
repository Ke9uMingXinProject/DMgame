package com.boxfish.ming.dmgame.ui.commons;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

import com.boxfish.ming.dmgame.DMgameApplication;
import com.boxfish.ming.dmgame.utils.PreferenceU;

// +----------------------------------------------------------------------
// | CreateTime: 16/4/15 
// +----------------------------------------------------------------------
// | Author:     xab(http://www.zhangkun.net.cn)
// +----------------------------------------------------------------------
// | CopyRight:  http://www.boxfish.cn
// +----------------------------------------------------------------------
public class BasePresenterImp implements BasePresenter {

    protected Context context ;
    protected PreferenceU preferenceU ;


    public BasePresenterImp() {
        this.context = DMgameApplication.context();
        this.preferenceU = PreferenceU.getInstance(this.context);
    }

    protected String getString(int resId){
        return context.getString(resId);
    }
    protected Resources getString( ){
        return context.getResources();
    }

    protected AssetManager getAssets(){
        return context.getAssets();
    }
}
