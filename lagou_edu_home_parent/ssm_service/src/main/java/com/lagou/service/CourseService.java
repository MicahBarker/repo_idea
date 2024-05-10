package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/7 8:26
 */
public interface CourseService {

    /**
     * 多条件查询课程列表
     * */
    public List<Course> findCourseByCondition(CourseVO courseVO);

    /**
     * 保存课程信息
     * */
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    /**
     * 根据id获取课程信息
     * */
    public CourseVO findCourseById(int id);

    /**
     * 修改课程信息
     * */
    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException;

    /**
     * 修改课程状态
     * */
    public void updateCourseStatus(int id,int status);

}
