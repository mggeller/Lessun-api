package com.nagel.project.lessun.repository;

import com.nagel.project.lessun.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Long> {
}
