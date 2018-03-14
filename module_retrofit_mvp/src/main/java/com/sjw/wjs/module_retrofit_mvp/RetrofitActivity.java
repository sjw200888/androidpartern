package com.sjw.wjs.module_retrofit_mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.Gson;

import org.loveandroid.yinshp.lib_common.base.BaseRetrofit;
import org.loveandroid.yinshp.lib_common.bean.TestBean;
import org.loveandroid.yinshp.lib_common.constanst.Datas;
import org.loveandroid.yinshp.lib_common.rehttp.retrofit.RetrofitInit;
import org.loveandroid.yinshp.lib_common.utils.Tools;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@Route(path = "/retrofit/RetrofitActivity")
public class RetrofitActivity extends AppCompatActivity {

    private Context context=RetrofitActivity.this;
    @BindView(R2.id.btn_retrofit)
    Button btnRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        ButterKnife.bind(this);
    }

    @OnClick(R2.id.btn_retrofit)
    public void onViewClicked() {
        //先将url和map组合在一起请求
        Call<ResponseBody>  call= RetrofitInit.getIntence().getInfo(getMap());

        BaseRetrofit baseRetrofit=new BaseRetrofit(){

            @Override
            protected void showData(String jsonStr) {
                super.showData(jsonStr);
                 //Gson解析
                    TestBean testBean=new Gson().fromJson(jsonStr,TestBean.class);
                    Toast.makeText(context,"code:"+testBean.getCode(),Toast.LENGTH_LONG).show();

            }

            @Override
            protected void showError(int i, Throwable t) {
                super.showError(i, t);
                Toast.makeText(context,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        };
        //执行请求
        call.enqueue(baseRetrofit);
//        //retrofit的请求回调函数
//        Callback<ResponseBody> callback=new Callback<ResponseBody>() {
//            //请求成功
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//
////                try {
////                    Toast.makeText(context,response.body().string(),Toast.LENGTH_LONG).show();
////                } catch (IOException e) {
////                    e.printStackTrace();
////                }
//                //Gson解析
//                try {
//                    String jsonRst=response.body().string();
//                    TestBean testBean=new Gson().fromJson(jsonRst,TestBean.class);
//                    Toast.makeText(context,"code:"+testBean.getCode(),Toast.LENGTH_LONG).show();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//
//            //请求失败
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//                Toast.makeText(context,t.getMessage()+"",Toast.LENGTH_LONG).show();
//            }
//        };

//        //执行请求
//        call.enqueue(callback);

    }

    private Map<String,String> getMap() {
//设置测试userid
        Datas.USERID = "33158";
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("action", "advst");
        map.put("func", "advList");
        map.put("userId", Datas.USERID);
        map.put("curPage", "1");
        map.put("pageSize", "10");
        map = Tools.getAllUrl(map, context, true);

        return map;

    }
}
