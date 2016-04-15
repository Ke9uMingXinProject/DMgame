package com.boxfish.ming.dmgame.ui.commons;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.boxfish.ming.dmgame.component.AppComponent;
import com.boxfish.ming.dmgame.utils.OttoManager;
import com.trello.rxlifecycle.components.support.RxFragmentActivity;

import butterknife.ButterKnife;

// +----------------------------------------------------------------------
// | CreateTime: 16/4/15 
// +----------------------------------------------------------------------
// | Author:     xab(http://www.zhangkun.net.cn)
// +----------------------------------------------------------------------
// | CopyRight:  http://www.boxfish.cn
// +----------------------------------------------------------------------
public abstract class BaseActivity extends RxFragmentActivity implements BaseViewInferface {

    public Context context;
    public Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getArgs(this.getIntent().getExtras());
        this.setContentView(this.setView());
        ButterKnife.bind(this);
        this.activity = this;
        this.context = this;
        OttoManager.register(this);
        this.initView();
        this.setListener();
    }

    public abstract void getArgs(Bundle bundle);

    public abstract int setView();

    public abstract void initView();

    public abstract void setListener();

    public void onBackPressed() {
        this.finish();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected abstract void setupComponent(AppComponent appComponent);

    protected void onDestroy() {
        System.gc();
        super.onDestroy();
        ButterKnife.unbind(this);
        OttoManager.unregister(this);
    }

    protected void startActivity(Class cls) {
        this.startActivity(cls, (Bundle)null, false);
    }

    protected void startActivity(Class cls, boolean isfinish) {
        this.startActivity(cls, (Bundle)null, isfinish);
    }

    protected void startActivity(Class cls, Bundle bundle) {
        this.startActivity(cls, bundle, false);
    }

    protected void startActivity(Class cls, Bundle bundle, boolean isfinish) {
        if(cls != null && this.activity != null && !this.activity.isFinishing()) {
            Intent intent = new Intent();
            if(bundle != null) {
                intent.putExtras(bundle);
            }

            intent.setClass(this.activity, cls);
            this.startActivity(intent);
            if(isfinish) {
                this.finish();
            }

        }
    }
}
