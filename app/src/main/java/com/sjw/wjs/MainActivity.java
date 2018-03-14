package com.sjw.wjs;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private Button btn_test;
    private Button sendvalue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         btn_test=(Button) findViewById(R.id.test);
        sendvalue=(Button) findViewById(R.id.sendvalue);
        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //进行跳转
                ARouter.getInstance().build("/test/testActivity").navigation();
            }
        });
        sendvalue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Message msg=new Message();
                msg.what=1;
                msg.obj="传值测试";
                EventBus.getDefault().postSticky(msg);
//进行跳转
                ARouter.getInstance().build("/test/testActivity").navigation();

            }
        });
        //初始化eventbus
        EventBus.getDefault().register(this);

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void getEventBus(Message msg){

//        if (msg.what==1){
//
//            Toast.makeText(this,(String)msg.obj, Toast.LENGTH_LONG).show();
//        }

    }
}


