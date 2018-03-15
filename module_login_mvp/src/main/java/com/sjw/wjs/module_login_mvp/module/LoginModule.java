package com.sjw.wjs.module_login_mvp.module;

import android.text.TextUtils;

/**
 * =========================================
 * Author : yinshengpan
 * Email : yinshp0423@163.com
 * Created date :　2018/3/15 14:57
 * Describe :
 * ==========================================
 */
public class LoginModule implements ILoginModule{
    //用户名
    private String mName;
    //密码
    private String mPsd;

    public LoginModule(String mName, String mPsd) {
        this.mName = mName;
        this.mPsd = mPsd;
    }
    public LoginModule() {

    }

    @Override
    public boolean checkNullUser(String name) {
        return TextUtils.isEmpty(name)?true:false;
    }

    @Override
    public boolean checkNullPsd(String psd) {
        return TextUtils.isEmpty(psd)?true:false;
    }


}
