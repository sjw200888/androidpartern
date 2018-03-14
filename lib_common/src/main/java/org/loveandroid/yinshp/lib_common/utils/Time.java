package org.loveandroid.yinshp.lib_common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 2018/3/7.
 */

public class Time {

    /**
     *
     *转换得到时间戳，目的是将分和秒去掉
     * @return
     */
    public static String getTimestamp() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Date curDate = new Date(System.currentTimeMillis());
        String currentTime = formatter.format(curDate);
        currentTime = currentTime.substring(0, currentTime.length() - 6) + "00分00秒";
        return getTime(currentTime);

    }

    /**
     *
     * @param user_time 传入的字符串时间
     * @return
     */
    public static String getTime(String user_time) {
        String re_time = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        Date d;
        try {
            d = sdf.parse(user_time);
            long l = d.getTime();
            String str = String.valueOf(l);
            re_time = str.substring(0, 10);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return re_time;
    }
}
