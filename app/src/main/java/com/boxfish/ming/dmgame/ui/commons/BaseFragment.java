package com.boxfish.ming.dmgame.ui.commons;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boxfish.ming.dmgame.component.AppComponent;
import com.boxfish.ming.dmgame.utils.OttoManager;

import butterknife.ButterKnife;

// +----------------------------------------------------------------------
// | CreateTime: 16/4/15 
// +----------------------------------------------------------------------
// | Author:     xab(http://www.zhangkun.net.cn)
// +----------------------------------------------------------------------
// | CopyRight:  http://www.boxfish.cn
// +----------------------------------------------------------------------
public abstract class BaseFragment extends Fragment {

    public Context context;
    public Activity activity;
    protected View rootView;

    public BaseFragment() {
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.getArgs(this.getArguments());
        this.rootView = inflater.inflate(this.setView(), (ViewGroup)null);
        ButterKnife.bind(this, this.rootView);
        this.activity = this.getActivity();
        this.context = this.activity.getApplicationContext();
        OttoManager.register(this);
        this.initView();
        this.setListener();
        return this.rootView;
    }

    protected abstract void getArgs(Bundle var1);

    protected abstract int setView();

    public abstract void initView();


    public abstract void setListener();

    protected abstract void setupComponent(AppComponent appComponent);

    protected void startActivity(Class cls) {
        this.startActivity(cls, (Bundle)null);
    }

    protected void startActivity(Class cls, Bundle bundle) {
        if(cls != null && this.activity != null && !this.activity.isFinishing()) {
            Intent intent = new Intent();
            if(bundle != null) {
                intent.putExtras(bundle);
            }

            intent.setClass(this.activity, cls);
            this.startActivity(intent);
        }
    }

    public void onDestroyView() {
        super.onDestroy();
        ButterKnife.unbind(this);
        OttoManager.unregister(this);
    }
}
