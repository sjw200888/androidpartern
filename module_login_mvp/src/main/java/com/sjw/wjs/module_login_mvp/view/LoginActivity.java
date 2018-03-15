package com.sjw.wjs.module_login_mvp.view;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sjw.wjs.lib_custom.permission.DefaultRationale;
import com.sjw.wjs.lib_custom.permission.PermissionSetting;
import com.sjw.wjs.module_login_mvp.R;
import com.sjw.wjs.module_login_mvp.R2;
import com.sjw.wjs.module_login_mvp.presenter.LoginPresenter;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.Rationale;

import org.loveandroid.yinshp.lib_common.base.BaseActivity;
import org.loveandroid.yinshp.lib_common.constanst.Datas;
import org.loveandroid.yinshp.lib_common.utils.MD5;
import org.loveandroid.yinshp.lib_common.utils.Tools;
import org.loveandroid.yinshp.lib_common.utils._loadingDialog;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/mvplogin/mvploginActivity")
public class LoginActivity extends BaseActivity implements ILoginView {

    //上下文
    private Context context = LoginActivity.this;
    @BindView(R2.id.userName)
    EditText userName;
    @BindView(R2.id.userPsd)
    EditText userPsd;
    @BindView(R2.id.useLogin)
    Button useLogin;
    private Rationale mRationale;
    private PermissionSetting mSetting;
    LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mRationale = new DefaultRationale();
        mSetting = new PermissionSetting(this);
        presenter=new LoginPresenter(this);
    }

    @OnClick(R2.id.useLogin)
    public void onViewClicked() {

        requestPermission(Permission.READ_PHONE_STATE);

//        //获取到imei后再去请求 不然为空 接口有问题
//        presenter.login();
    }

    @Override
    public String getUserName() {
        return userName.getText().toString();
    }

    @Override
    public String getPsd() {
        return userPsd.getText().toString();
    }

    @Override
    public void showPro() {
        _loadingDialog.submitLoading(context, "正在登录");
    }

    @Override
    public void hidePro() {
        _loadingDialog.dismissLoading();

    }

    @SuppressLint("MissingPermission")
    @Override
    public HashMap<String, String> getMap() {

        //设置测试userid
        Datas.USERID = "33158";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("action", "login");
        map.put("func", "login");
        map.put("account", userName.getText().toString());
        map.put("imei", Datas.IMEI);
        map.put("password", MD5.getMD5(userPsd.getText().toString()));
        map = Tools.getAllUrl(map, context, true);
        return map;
    }




    @SuppressLint("MissingPermission")
    @Override
    public void getImei() {

        //获取imei
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
        Datas.IMEI = telephonyManager.getDeviceId();

        //获取到imei后再去请求 不然为空 接口有问题
        presenter.login();
    }

    @Override
    public void showNull(int i) {
        //0是用户名 1是密码
        if (i==0){
            Toast.makeText(context,"用户名为空",Toast.LENGTH_LONG).show();
        }else if (i==1){
            Toast.makeText(context,"密码为空",Toast.LENGTH_LONG).show();
        }
        return;

    }

    @Override
    public void success() {
        Toast.makeText(context,"登录成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void fail() {
        Toast.makeText(context,"登录失败",Toast.LENGTH_LONG).show();
    }

    //请求权限
    private void requestPermission(String... permissions) {
        AndPermission.with(context)
                .permission(permissions)
                .rationale(mRationale)
                .onGranted(new Action() {
                    @Override
                    public void onAction(List<String> permissions) {
                        getImei();
                    }
                })
                .onDenied(new Action() {
                    @Override
                    public void onAction(@NonNull List<String> permissions) {

                        if (AndPermission.hasAlwaysDeniedPermission(context, permissions)) {
                            mSetting.showSetting(permissions);
                        }
                    }
                })
                .start();
    }

}
