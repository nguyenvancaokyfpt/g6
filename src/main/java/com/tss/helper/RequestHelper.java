package com.tss.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tss.constants.ActionConstants;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.ScreenConstants;
import com.tss.model.payload.ResponseMessage;
import com.tss.model.sercurity.Permission;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestHelper {

    // Get Json data from post request
    public static JSONObject getJsonData(HttpServletRequest request) {
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            /* report an error */ }
        JSONObject jsonObject = JSONObject.parseObject(jb.toString());
        return jsonObject;
    }

    public static <T> T getJsonData(HttpServletRequest request, Class<T> clazz) {
        StringBuffer jb = new StringBuffer();
        String line = null;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null)
                jb.append(line);
        } catch (Exception e) {
            /* report an error */ }
        T jsonObject = JSONObject.parseObject(jb.toString(), clazz);
        return jsonObject;
    }

    // Response Bad Request
    public static void responseBadRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("application/json");
            response.setStatus(HttpStatusCodeConstants.BAD_REQUEST); // Bad Request
            try (PrintWriter writer = response.getWriter()) {
                ResponseMessage responseMessage = new ResponseMessage();
                responseMessage.setStatus("error");
                responseMessage.setCode(HttpStatusCodeConstants.BAD_REQUEST);
                responseMessage.setMessage("Bad Request");
                writer.write(JSONArray.toJSONString(responseMessage));
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Check is public access
    public static boolean isPublicAccess(String uri) {
        for (ScreenConstants screen : ScreenConstants.publicScreen()) {
            // Check if uri is public access
            if (uri.equals(screen.getPath())) {
                return true;
            }
        }
        // Allow access to assets
        if (uri.startsWith(ScreenConstants.ASSETS.getPath())) {
            return true;
        }
        return false;
    }

    public static boolean isExist(String uri) {
        for (ScreenConstants screen : ScreenConstants.allScreen()) {
            if (uri.equals(screen.getPath())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAllowedAccess(List<Permission> permissions, String uri, String action) {
        for (Permission permission : permissions) {
            ScreenConstants screen = ScreenConstants.getScreenById(permission.getScreenId());
            if (screen != null) {
                if (screen.getPath().equals(uri)) {
                    switch (action) {
                        case ActionConstants.DELETE:
                            if (permission.isCanDelete()) {
                                return true;
                            } else {
                                return false;
                            }
                        case ActionConstants.UPDATE:
                            if (permission.isCanUpdate()) {
                                return true;
                            } else {
                                return false;
                            }
                        case ActionConstants.CREATE:
                            if (permission.isCanCreate()) {
                                return true;
                            } else {
                                return false;
                            }
                        default:
                            if (permission.isCanGet()) {
                                return true;
                            } else {
                                return false;
                            }
                    }
                }
            }
        }
        return false;
    }

    // get host
    public static String getHost(HttpServletRequest request) {
        StringBuffer url = request.getRequestURL();
        String uri = request.getRequestURI();
        return url.substring(0, url.indexOf(uri));
    }

    public static JSONObject getJsonDataForm(HttpServletRequest request) {
        JSONObject jsonObject = JSONObject.parseObject(JSONArray.toJSONString(request.getParameterMap()));
        return jsonObject;
    }
}
