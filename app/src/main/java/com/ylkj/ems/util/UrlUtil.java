package com.ylkj.ems.util;

import android.content.Context;

/**
 * Created by fan on 2018/4/14.
 */

public class UrlUtil {
    public static String ip ="90.15.12.80";
    public static String prot ="8080";
     public static String http = "http://";

    public String getUrl(Context mContext){
        return http+SPUtils.get(mContext,"serviceIP",UrlUtil.ip)+":"+SPUtils.get(mContext,"serviceProt",UrlUtil.prot);
    }
}
