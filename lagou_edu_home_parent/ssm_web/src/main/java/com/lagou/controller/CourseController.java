package com.lagou.controller;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/7 8:30
 */

import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.CourseService;
import com.lagou.utils.FileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    /**
     * 查询课程信息&条件查询 接口
     */
    @RequestMapping("/findCourseByCondition")
    public ResponseResult findCourseByConditioin(@RequestBody CourseVO courseVO) {
        List<Course> courseList = courseService.findCourseByCondition(courseVO);
        ResponseResult result = new ResponseResult(true, 200, "响应成功", courseList);
        return result;
    }

    @RequestMapping("/courseUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        Map<String, String> map = FileUpload.upload(file, request);
        ResponseResult result = new ResponseResult(true, 200, "响应成功", map);
        return result;
    }

    /**
     * 新增课程信息及讲师信息
     * 新增课程信息和修改课程信息要写在同一个方法中
     */
    @RequestMapping("/saveOrUpdateCourse")
    public ResponseResult saveOrUpdateCourse(@RequestBody CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        Integer id = courseVO.getId();
        ResponseResult result;
        if (id == null) {
            courseService.saveCourseOrTeacher(courseVO);
            result = new ResponseResult(true, 200, "新增成功", null);
        } else {
            courseService.updateCourseOrTeacher(courseVO);
            result = new ResponseResult(true, 200, "更新成功", null);
        }
        return result;
    }

    /**
     * 根据id获取课程信息
     */
    @RequestMapping("/findCourseById")
    public ResponseResult findCourseById(@RequestParam int id) {
        try {
            CourseVO courseVO = courseService.findCourseById(id);
            ResponseResult result = new ResponseResult(true, 200, "响应成功", courseVO);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 修改课程状态
     * */
    @RequestMapping("/updateCourseStatus")
    public ResponseResult updateCourseStatus(@RequestParam int id, @RequestParam int status) {
        try {
            //执行修改操作
            courseService.updateCourseStatus(id, status);
            //保存修改后的状态,并返回
            Map<String, Integer> map = new HashMap<>();
            map.put("status", status);
            ResponseResult result = new ResponseResult(true, 200, "响应成功", map);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
