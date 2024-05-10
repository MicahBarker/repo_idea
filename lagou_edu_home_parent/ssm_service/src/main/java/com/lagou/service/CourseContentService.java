package com.lagou.service;

import com.lagou.domain.Course;
import com.lagou.domain.CourseLesson;
import com.lagou.domain.CourseSection;

import java.util.List;

/**
 * @Author 青科大-任安全
 * @Create 2024/5/7 16:05
 */
public interface CourseContentService {

    public List<CourseSection> findSectionAndLessonByCourseId(int courseId);

    public Course findCourseByCourseId(int courseId);

    public void saveSection(CourseSection section);

    public void updateSection(CourseSection section);

    public void updateSectionStatus(int id,int status);

    public void saveLesson(CourseLesson lesson);

    public void updateLesson(CourseLesson lesson);
}
