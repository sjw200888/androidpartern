package com.sjw.wjs.module_login_mvp.module;

/**
 * =========================================
 * Author : yinshengpan
 * Email : yinshp0423@163.com
 * Created date :　2018/3/15 14:59
 * Describe :
 * ==========================================
 */
public interface ILoginModule {

    //检查用户名是否为空
    boolean checkNullUser(String name);
    //检查密码是否为空
    boolean checkNullPsd(String psd);



}
