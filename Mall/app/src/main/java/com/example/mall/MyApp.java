package com.example.mall;

import android.app.Application;
import android.content.Context;


import com.xuexiang.xui.XUI;


/**
 * 应用初始化
 *
 * @author xuexiang
 * @since 2018/11/7 下午1:12
 */
public class MyApp extends Application {
    private static Application sContext;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        initUI();
        //初始化基础库

    }

    /**
     * 初始化XUI 框架
     */
    private void initUI() {
        XUI.init(this);
        XUI.debug(MyApp.isDebug());
//        //设置默认字体为华文行楷
//        XUI.getInstance().initFontStyle("fonts/hwxk.ttf");

    }


    public static boolean isDebug() {
        return BuildConfig.DEBUG;
    }


}
