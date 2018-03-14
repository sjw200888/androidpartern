package org.loveandroid.yinshp.lib_common.base;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * =========================================
 * Author : yinshengpan
 * Email : yinshp0423@163.com
 * Created date :　2018/3/12 11:31
 * Describe :
 * ==========================================
 */
//这里写基础Application
public class BaseApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化路由
        ARouter.openLog(); // 打印日志
         ARouter.openDebug();
        // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！
        // 线上版本需要关闭,否则有安全风险)
        ARouter.init( this ); // 尽可能早，推荐在Application中初始化
    }
}
