package com.lagou.service.impl;

import com.github.pagehelper.PageInfo;
import com.lagou.dao.CourseMapper;
import com.lagou.domain.Course;
import com.lagou.domain.CourseVO;
import com.lagou.domain.Teacher;
import com.lagou.service.CourseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/7 8:27
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> findCourseByCondition(CourseVO courseVO) {
        List<Course> courseList = courseMapper.findCourseByConditioin(courseVO);
        return courseList;
    }

    @Override
    public void saveCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        // 封装课程信息
        Course course = new Course();

        BeanUtils.copyProperties(course, courseVO);  // 把courseVO系统的复制到course中

        // 补全课程信息
        Date date = new Date();
        course.setCreateTime(date);
        course.setUpdateTime(date);

        // 保存课程
        courseMapper.saveCourse(course);

        // 获取新插入数据的Id值
        int id = course.getId();

        // 封装讲师信息
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher, courseVO);

        // 补全讲师信息
        teacher.setCourseId(id);
        teacher.setCreateTime(date);
        teacher.setUpdateTime(date);
        teacher.setIsDel(0);

        // 保存讲师信息
        courseMapper.saveTeacher(teacher);
    }

    @Override
    public CourseVO findCourseById(int id) {
        return courseMapper.findCourseById(id);
    }

    @Override
    public void updateCourseOrTeacher(CourseVO courseVO) throws InvocationTargetException, IllegalAccessException {
        //封装课程信息
        Course course = new Course();
        BeanUtils.copyProperties(course, courseVO);
        //补全信息
        Date date = new Date();
        course.setUpdateTime(date);
        //更新课程
        courseMapper.updateCourse(course);

        //封装讲师信息
        Teacher teacher = new Teacher();
        BeanUtils.copyProperties(teacher, courseVO);
        //补全信息
        teacher.setCourseId(course.getId());
        teacher.setUpdateTime(date);
        //更新讲师信息
        courseMapper.updateTeacher(teacher);
    }

    @Override
    public void updateCourseStatus(int id, int status) {
        try {
            //封装数据
            Course course = new Course();
            course.setStatus(status);
            course.setId(id);
            course.setUpdateTime(new Date());
            //调用Dao
            courseMapper.updateCourseStatus(course);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
