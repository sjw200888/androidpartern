package org.loveandroid.yinshp.lib_common.rehttp.retrofit;

import android.util.Log;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * =========================================
 * Author : yinshengpan
 * Email : yinshp0423@163.com
 * Created date :　2018/3/14 14:12
 * Describe :
 * ==========================================
 */
public class RetrofitInit {

    private static RetrofitApi retrofitApi;

    public static RetrofitApi  getIntence(){

        if (retrofitApi==null){
            Retrofit retrofit=new Retrofit.Builder()
                    .baseUrl(ApiUrl.BaseURL)
                    .addConverterFactory(GsonConverterFactory.create(new Gson()))
                    .client(getOkHttpClient())
                    .build();
            retrofitApi=retrofit.create(RetrofitApi.class);


        }

        return retrofitApi;



    }


    private static OkHttpClient getOkHttpClient() {

        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
//                AllCanuseUtils.showLog("sjw", message);
                Log.i("loggingInterceptor", message);
            }
        });
        loggingInterceptor.setLevel(level);

        //定制OkHttp
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient
                .Builder().connectTimeout(20, TimeUnit.SECONDS);
        //OkHttp进行添加拦截器loggingInterceptor
        httpClientBuilder.addInterceptor(loggingInterceptor);
        return httpClientBuilder.build();


    }


}
