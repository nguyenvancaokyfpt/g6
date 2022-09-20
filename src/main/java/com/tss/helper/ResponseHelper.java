package com.tss.helper;

import java.io.IOException;
import java.io.PrintWriter;

import com.alibaba.fastjson.JSONArray;
import com.tss.model.payload.ListResponseMessage;
import com.tss.model.payload.ResponseMessage;

import jakarta.servlet.http.HttpServletResponse;

public class ResponseHelper {
    public static void sendResponse(HttpServletResponse response, ResponseMessage data)
            throws IOException {
        try {
            response.setContentType("application/json");
            response.setStatus(data.getCode());
            try (PrintWriter writer = response.getWriter()) {
                writer.write(JSONArray.toJSONString(data));
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendResponse(HttpServletResponse response, ListResponseMessage data)
            throws IOException {
        try {
            response.setContentType("application/json");
            try (PrintWriter writer = response.getWriter()) {
                response.setStatus(data.getCode());
                writer.write(JSONArray.toJSONString(data));
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
