package com.sjw.wjs.module_login_mvp.view;

import java.util.HashMap;
import java.util.Map;

/**
 * =========================================
 * Author : yinshengpan
 * Email : yinshp0423@163.com
 * Created date :　2018/3/15 14:12
 * Describe :
 * ==========================================
 */
public interface ILoginView {

    //获取用户名
    String getUserName();
    //获取密码
    String getPsd();
    //加载的显示
    void showPro();
    //加载的隐藏
    void hidePro();
    //获取map
    HashMap<String,String> getMap();
    //获取imei
    void getImei();
    //显示空信息 0表示用户名  1表示密码
    void showNull(int i);
    //显示成功信息
    void success();
    //显示失败信息
    void fail();


}
