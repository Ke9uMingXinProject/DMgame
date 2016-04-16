package com.boxfish.ming.dmgame.utils.log;

import android.util.Log;

// +----------------------------------------------------------------------
// | CreateTime: 16/4/16 
// +----------------------------------------------------------------------
// | Author:     xab(http://www.zhangkun.net.cn)
// +----------------------------------------------------------------------
// | CopyRight:  http://www.boxfish.cn
// +----------------------------------------------------------------------
public abstract class CommLog {

    public CommLog() {
    }

    public void info(String TAG, Object str) {
        this.info(TAG, str, (String)null, true);
    }

    protected void info(String TAG, Object str, String className, boolean customClass) {
        if(customClass) {
            className = this.getMethodNames(Thread.currentThread().getStackTrace());
        }

        Log.i(TAG, this.createLog(className, String.valueOf(str)));
        this.saveLog(this.createLog(className, String.valueOf(str)));
    }

    public void debug(String TAG, Object str) {
        this.debug(TAG, str, (String)null, true);
    }

    protected void debug(String TAG, Object str, String className, boolean customClass) {
        if(customClass) {
            className = this.getMethodNames(Thread.currentThread().getStackTrace());
        }

        Log.d(TAG, this.createLog(className, String.valueOf(str)));
        this.saveLog(this.createLog(className, String.valueOf(str)));
    }

    public void error(String TAG, Object str) {
        this.error(TAG, str, (String)null, true);
    }

    protected void error(String TAG, Object str, String className, boolean customClass) {
        if(customClass) {
            className = this.getMethodNames(Thread.currentThread().getStackTrace());
        }

        Log.e(TAG, this.createLog(className, String.valueOf(str)));
        this.saveLog(this.createLog(className, String.valueOf(str)));
    }

    private void saveLog(String paramString) {
    }

    private String createLog(String className, String log) {
        return "[ " + className + " ] " + log;
    }

    protected abstract String getMethodNames(StackTraceElement[] var1);
}
