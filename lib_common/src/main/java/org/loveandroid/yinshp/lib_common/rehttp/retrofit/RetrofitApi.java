package org.loveandroid.yinshp.lib_common.rehttp.retrofit;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * =========================================
 * Author : yinshengpan
 * Email : yinshp0423@163.com
 * Created date :　2018/3/14 14:13
 * Describe :
 * ==========================================
 */
//组成url的
public interface RetrofitApi {



    @GET("broadcast/")
    Call<ResponseBody>   getInfo(@QueryMap Map<String, String> map);


    @GET("broadcast/")
    Call<ResponseBody>   login(@QueryMap Map<String, String> map);



}
