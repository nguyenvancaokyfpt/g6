package com.tss.helper;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.tss.model.util.DataTablesColumns;


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
