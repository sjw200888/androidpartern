package org.loveandroid.yinshp.module_test;


import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.loveandroid.yinshp.lib_common.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@Route(path = "/test/testActivity")
public class TestActivity extends BaseActivity {

    @BindView(R2.id.butterkBtn)
    Button butterkBtn;
    @BindView(R2.id.butterkBtn2)
    Button butterkBtn2;
    @BindView(R2.id.retrofitBtn)
    Button retrofitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);

        //初始化eventbus
        EventBus.getDefault().register(this);


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getEventBus(Message msg) {

        if (msg.what == 1) {

            Toast.makeText(this, (String) msg.obj, Toast.LENGTH_LONG).show();
        }

    }


    @OnClick({R2.id.butterkBtn, R2.id.butterkBtn2,R2.id.retrofitBtn})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.butterkBtn) {
            Toast.makeText(this, "butterkBtn", Toast.LENGTH_LONG).show();

        } else if (i == R.id.butterkBtn2) {
            Toast.makeText(this, "butterkBtn2", Toast.LENGTH_LONG).show();

        }else if (i == R.id.retrofitBtn) {
            Toast.makeText(this, "retrofitBtn2", Toast.LENGTH_LONG).show();
//进行跳转
            ARouter.getInstance().build("/retrofit/RetrofitActivity").navigation();
        }
    }


}
