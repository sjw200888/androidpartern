package org.loveandroid.yinshp.lib_common.base;

import org.loveandroid.yinshp.lib_common.utils.Tools;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * =========================================
 * Author : yinshengpan
 * Email : yinshp0423@163.com
 * Created date :　2018/3/14 15:23
 * Describe :
 * ==========================================
 */
public class BaseRetrofit implements Callback<ResponseBody>{
    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        //判断获取到的code
        try {
            String jsonStr=response.body().string();
            if (Tools.getobject(jsonStr,"code").equals("1"))
            {

                showData(jsonStr);

            }else {
                String message=Tools.getobject(jsonStr,"message");
                //第一个i用来判断错误，
                //第二个是错误的原因

                showError(-1,new RuntimeException(message));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }




    }

    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {

        showError(-2,t);

    }
    //返回数据的
    protected void showData(String jsonStr) {


    }



    //返回错误信息的
    protected void showError(int i, Throwable t) {
    }
}
