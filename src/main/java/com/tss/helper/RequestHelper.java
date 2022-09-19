package com.tss.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tss.constants.HttpStatusCodeConstants;
import com.tss.constants.RequestURIConstants;
import com.tss.model.payload.ResponseMessage;

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
        for (String publicAccessUri : RequestURIConstants.PUBLIC_ACCESS) {
            // Check if uri is public access
            if (uri.equals(publicAccessUri)) {
                return true;
            }
            // Allow access to assets
            if (uri.startsWith(RequestURIConstants.ASSETS)) {
                return true;
            }
        }
        return false;
    }
}
