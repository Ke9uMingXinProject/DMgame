package com.boxfish.ming.dmgame.utils;

import com.squareup.otto.Bus;

// +----------------------------------------------------------------------
// | CreateTime: 16/4/15 
// +----------------------------------------------------------------------
// | Author:     xab(http://www.zhangkun.net.cn)
// +----------------------------------------------------------------------
// | CopyRight:  http://www.boxfish.cn
// +----------------------------------------------------------------------
public class OttoManager {
    private static final Bus BUS = new Bus();

    public OttoManager() {
    }

    public static Bus getInstance() {
        return BUS;
    }

    public static void register(Object o) {
        getInstance().register(o);
    }

    public static void unregister(Object o) {
        getInstance().unregister(o);
    }
}
