package com.boxfish.ming.dmgame.utils;

import com.boxfish.ming.dmgame.utils.log.CommConfig;
import com.boxfish.ming.dmgame.utils.log.CommLog;

import cn.xabad.commons.lang3.StringUtils;

// +----------------------------------------------------------------------
// | CreateTime: 16/4/16 
// +----------------------------------------------------------------------
// | Author:     xab(http://www.zhangkun.net.cn)
// +----------------------------------------------------------------------
// | CopyRight:  http://www.boxfish.cn
// +----------------------------------------------------------------------
public class L extends CommLog {


    public static L getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private static class SingletonHolder {
        private static final L INSTANCE = new L();
    }

    public static void line() {
        i("/-----------------------------/");
    }

    public static void line(Object str) {
        i("/-----------------------------/" + str);
    }

    public static void el() {
        e("/-----------------------------/");
    }

    public static void el(Object str) {
        e("/-----------------------------/" + str);
    }

    public static void i() {
        getInstance().info(CommConfig.Tag, "");
    }

    public static void i(Object o) {
        getInstance().info(CommConfig.Tag, o);
    }

    public static void i(String tag, Object o) {
        getInstance().info(tag, o);
    }

    public static void d() {
        getInstance().debug(CommConfig.Tag, "");
    }

    public static void d(Object o) {
        getInstance().debug(CommConfig.Tag, o);
    }

    public static void d(String tag, Object o) {
        getInstance().debug(tag, o);
    }

    public static void e() {
        getInstance().error(CommConfig.Tag, "");
    }

    public static void e(Object o) {
        getInstance().error(CommConfig.Tag, o);
    }

    public static void e(Object o, boolean flag) {
        getInstance().error(CommConfig.Tag, o, "Exception", flag);
    }

    public static void e(String tag, Object o) {
        getInstance().error(tag, o);
    }

    @Override
    protected String getMethodNames(StackTraceElement[] sElements) {
        String className = "";
        int index = 3;
        try {
            className = getName(sElements[index++]);
            if (StringUtils.startsWithAny(className
                    , "com.mao.utils.tools.L."
                    , "cn.xabad.commons.tools.CommLog.")) {
                className = getName(sElements[index++]);
            }
            if (StringUtils.startsWithAny(className
                    , "com.mao.utils.tools.L."
                    , "cn.xabad.commons.tools.CommLog.")) {
                className = getName(sElements[index++]);
                if (StringUtils.startsWithAny(className
                        , "com.mao.utils.tools.L."
                        , "cn.xabad.commons.tools.CommLog.")) {
                    className = getName(sElements[index++]);
                    if (StringUtils.startsWithAny(className
                            , "com.mao.utils.tools.L."
                            , "cn.xabad.commons.tools.CommLog.")) {
                        className = getName(sElements[index++]);
                    }
                }
            }
        } catch (Exception e) {
        }
        return className;
    }

    private String getName(StackTraceElement element) {
//        String className = element.getFileName();
//        String methodName = element.getMethodName();
//        int lineNumber = element.getLineNumber();
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(methodName).append("(").append(className).append(":").append(lineNumber).append(")#");
        return element.toString();
    }


}
