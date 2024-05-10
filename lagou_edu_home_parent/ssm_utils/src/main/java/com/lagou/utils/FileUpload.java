package com.lagou.utils;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/8 9:10
 */
public class FileUpload {
    public static Map<String, String> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        //1.判断文件是否为空
        if (file.isEmpty()) {
            throw new RuntimeException();
        }

        //2.获取项目部署路径
        // D:\apache-tomcat-8.5.56\webapps\ssm_web\
        String realPath = request.getServletContext().getRealPath("/");
        // D:\apache-tomcat-8.5.56\webapps\
        String webappsPath = realPath.substring(0, realPath.indexOf("ssm-web"));

        //3.获取原文件名
        String fileName = file.getOriginalFilename();

        //4.新文件名
        String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));

        //5.上传文件
        String uploadPath = webappsPath + "upload\\";
        File filePath = new File(uploadPath, newFileName);

        //如果目录不存在就创建目录
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
            System.out.println("创建目录: " + filePath);
        }
        try {
            file.transferTo(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //6.将文件名和文件路径返回
        Map<String, String> map = new HashMap<>();
        map.put("fileName", newFileName);
        map.put("filePath", "http://localhost:8080/upload/" + newFileName);

        return map;
    }
}
