package com.example.projetcourse.repositories;


import com.example.projetcourse.entites.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // Add custom query methods if needed
}
