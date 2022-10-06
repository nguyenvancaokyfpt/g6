package com.tss.helper;

import com.alibaba.fastjson.JSONArray;


public class DebugHelper {
    public static void log(Object data){
        try {
            System.out.println(JSONArray.toJSONString(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void print(Object data) {
        log(data);
    }
}
