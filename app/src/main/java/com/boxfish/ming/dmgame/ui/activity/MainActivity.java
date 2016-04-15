package com.boxfish.ming.dmgame.ui.activity;

import android.os.Bundle;

import com.boxfish.ming.dmgame.R;
import com.boxfish.ming.dmgame.component.AppComponent;
import com.boxfish.ming.dmgame.component.DaggerMainComponent;
import com.boxfish.ming.dmgame.modules.MainModule;
import com.boxfish.ming.dmgame.ui.commons.BaseActivity;
import com.boxfish.ming.dmgame.ui.features.IMainView;
import com.boxfish.ming.dmgame.ui.presenter.MainPresenter;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements IMainView{


    @Inject
    MainPresenter presenter;
    
    @Override
    public void getArgs(Bundle bundle) {
        
    }

    @Override
    public int setView() {
        return R.layout.aty_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void setListener() {

    }

    @Override
    protected void setupComponent(AppComponent appComponent) {

        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);

    }
}
