package com.nagel.project.lessun.repository;

import com.nagel.project.lessun.dto.CourseDTO;
import com.nagel.project.lessun.entity.Course;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICourseRepository extends JpaRepository<Course, Long> {

    @Query(value = "SELECT c FROM Course c WHERE c.title LIKE %:title%")
    List<Course> findCoursesByTitle(@Param("title") String title);
}
