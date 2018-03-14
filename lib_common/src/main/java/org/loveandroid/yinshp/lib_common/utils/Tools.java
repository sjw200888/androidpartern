package org.loveandroid.yinshp.lib_common.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.loveandroid.yinshp.lib_common.constanst.Datas;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



/**
 * Created by admin on 2018/3/7.
 */

public class Tools {

    /**
     * 判断手机号是否符合规范 * @param phoneNo 输入的手机号 * @return
     */
    public static boolean isPhoneNumber(String phoneNo) {
        if (TextUtils.isEmpty(phoneNo)) {
            return false;
        }
        if (phoneNo.length() == 11) {
            for (int i = 0; i < 11; i++) {
                if (!PhoneNumberUtils.isISODigit(phoneNo.charAt(i))) {
                    return false;
                }
            }
            Pattern p = Pattern.compile("^((13[^4,\\D])" + "|(134[^9,\\D])" + "|(14[5,7])" + "|(15[^4,\\D])" + "|(17[3,6-8])" + "|(18[0-9]))\\d{8}$");
            Matcher m = p.matcher(phoneNo);
            return m.matches();
        }
        return false;
    }


    /**
     * 获取类似message code结构的json对象
     *
     * @param result
     * @return
     * @throws JSONException
     */
    public static String getobject(String result, String objectName) {
        String resultFlag = "";
        try {
            JSONObject jsonObject = new JSONObject(result);
            // JSONObject baseModel = jsonObject.getJSONObject("baseModel");
            resultFlag = jsonObject.getString(objectName);
            return resultFlag;
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return resultFlag;
    }

    /**
     * 得到url
     * /**
     * 组成请求url
     *
     * @param map
     * @param context
     * @param isCheckUserid
     * @return
     */
    public static HashMap<String, String> getAllUrl(HashMap<String, String> map, Context context, boolean isCheckUserid) {
        HashMap<String, String> resultMap = new HashMap<>();
        resultMap.putAll(map);
        //时间
        String timestamp = Time.getTimestamp();
        //spm
        String spm = null;
        //是否监测userid
        if (isCheckUserid) {

            spm = Datas.androidID + "." + Tools.getAppVersionName(context) + "." + Datas.USERID + "." + timestamp
                    + ".1";
        } else {
            spm = Datas.androidID + "." + Tools.getAppVersionName(context) + "." + 0 + "." + timestamp
                    + ".0";

        }

        map.put("token_key", Datas.KEY);
        map.put("time", timestamp);
        map.put("sourceID", Datas.androidID);
        ArrayList<String> mapKeyList = new ArrayList<String>();
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = entry.getKey().toString();

            String val = entry.getValue().toString();
            mapKeyList.add(key);
        }
        String[] arr = (String[]) mapKeyList.toArray(new String[mapKeyList.size()]);
        String str = Tools.AsciiSort(arr, map);
        String bobao_token = MD5.getMD5(str);
        resultMap.remove("time");
        resultMap.remove("token_key");
        resultMap.remove("sourceID");
        resultMap.put("spm", URLEncoder.encode(spm));
        resultMap.put("bobao_token", bobao_token);
        return resultMap;
    }

    /**
     * 根据ASCII码排序
     *
     * @param
     * @return
     */
    public static String AsciiSort(String[] str, HashMap<String, String> map) {
        String temp = "";
        for (int i = str.length - 1; i > 0; --i) {
            for (int j = 0; j < i; ++j) {
                int maxStr = str[j].length();
                if (str[j].length() < str[j + 1].length()) {
                    maxStr = str[j + 1].length();
                }
                if (isExchange(str[j], str[j + 1], maxStr)) {
                    temp = str[j];
                    str[j] = str[j + 1];
                    str[j + 1] = temp;
                }

            }
        }
        String str_token = "";
        for (int i = 0; i < str.length; i++) {
            str_token += map.get(str[i]);
        }
        return str_token;

    }

    /**
     * 交换
     *
     * @param str1
     * @param str2
     * @param maxStr
     * @return
     */
    private static boolean isExchange(String str1, String str2, int maxStr) {
        for (int i = 0; i < maxStr; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.charAt(i) > str2.charAt(i);
            }
        }

        return true;
    }

    /**
     * 返回当前程序版本名
     */
    public static String getAppVersionName(Context context) {
        String versionName = "";
        int versioncode = 0;
        try {
            // ---get the package info---
            PackageManager pm = context.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = pi.versionName;
            versioncode = pi.versionCode;
            if (versionName == null || versionName.length() <= 0) {
                return "";
            }
        } catch (Exception e) {
            Log.e("VersionInfo", "Exception", e);
        }
        return versionName;
    }
}
