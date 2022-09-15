package com.tss.helper;

import java.io.BufferedReader;

import com.alibaba.fastjson.JSONObject;

import jakarta.servlet.http.HttpServletRequest;

public class RequestHelper {
    // Get Json data from post request
    public static JSONObject getJsonData(HttpServletRequest request) {
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
          BufferedReader reader = request.getReader();
          while ((line = reader.readLine()) != null)
            jb.append(line);
        } catch (Exception e) { /*report an error*/ }
        JSONObject jsonObject = JSONObject.parseObject(jb.toString());
        return jsonObject;
    }
}
