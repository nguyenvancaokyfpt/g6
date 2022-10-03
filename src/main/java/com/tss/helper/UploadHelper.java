package com.tss.helper;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class UploadHelper {
    // This function will single file or multiple files and return list of file url
    // File must be in the form-data with name "file"
    public static List<String> upload(HttpServletRequest request, String destination) {
        String appPath = request.getServletContext().getRealPath("");
        appPath = appPath.replace('\\', '/');
        String relativePath = "assets/media/" + destination;
        String savePath = appPath + relativePath;



        try {
            // creates the save directory if it does not exists
            java.io.File fileSaveDir = new java.io.File(savePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }
            List<String> fileUrls = new ArrayList<>();
            for (Part part : request.getParts()) {
                String fileName = part.getSubmittedFileName();
                if (fileName != null && fileName.length() > 0) {
                    // unique file name with timestamp
                    String uniqueFileName = System.currentTimeMillis() + "_" + fileName;
                    String filePath = savePath + "/" + uniqueFileName;
                    fileUrls.add(relativePath + "/" + uniqueFileName);
                    DebugHelper.print("Write attachment to file: " + filePath);
                    part.write(filePath);
                    }
            }
            return fileUrls;
        } catch (Exception e) {
            DebugHelper.print(e);
            return null;
        }
    }

}
