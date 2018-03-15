package com.sjw.wjs.module_login_mvp.presenter;

import android.support.annotation.NonNull;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import com.sjw.wjs.module_login_mvp.module.ILoginModule;
import com.sjw.wjs.module_login_mvp.module.LoginModule;
import com.sjw.wjs.module_login_mvp.view.ILoginView;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;

import org.loveandroid.yinshp.lib_common.base.BaseRetrofit;
import org.loveandroid.yinshp.lib_common.constanst.Datas;
import org.loveandroid.yinshp.lib_common.rehttp.retrofit.RetrofitInit;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * =========================================
 * Author : yinshengpan
 * Email : yinshp0423@163.com
 * Created date :　2018/3/15 15:03
 * Describe :
 * ==========================================
 */
public class LoginPresenter {
    private LoginModule module;
    private ILoginView view;

    public LoginPresenter(ILoginView view){
        this.view=view;
        module=new LoginModule();

    }

    //登录
    public void login(){
        //检测用户名和密码是否为空
        if (module.checkNullUser(view.getUserName())){
               view.showNull(0);
        }else if(module.checkNullPsd(view.getPsd())){
               view.showNull(1);
        }
        //请求数据
        view.showPro();
        Call<ResponseBody> call= RetrofitInit.getIntence().login(view.getMap());
        BaseRetrofit baseRetrofit=new BaseRetrofit(){
            @Override
            protected void showData(String jsonStr) {
                super.showData(jsonStr);
                view.success();
                view.hidePro();

            }

            @Override
            protected void showError(int i, Throwable t) {
                super.showError(i, t);
                view.fail();
                view.hidePro();
            }
        };
        //加入请求队列
        call.enqueue(baseRetrofit);







    }







}
