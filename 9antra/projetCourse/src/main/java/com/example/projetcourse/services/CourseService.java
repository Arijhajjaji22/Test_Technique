package com.example.projetcourse.services;


import com.example.projetcourse.entites.Course;
import com.example.projetcourse.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course addCourse(Course course) {
        
        return courseRepository.save(course);
    }

    public Course updateCourse(Long courseId, Course updatedCourse) {

        if (courseRepository.existsById(courseId)) {
            updatedCourse.setId(courseId);
            return courseRepository.save(updatedCourse);
        }
        return null;
    }

    public void deleteCourse(Long courseId) {
        // Add validation logic if needed
        courseRepository.deleteById(courseId);
    }
}
