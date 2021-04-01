package com.nagel.project.lessun.service;

import com.nagel.project.lessun.entity.Course;
import com.nagel.project.lessun.entity.Review;
import com.nagel.project.lessun.repository.ICourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseService {
    private final ICourseRepository courseRepository;

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course getCourse(Long id) {
        return courseRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Course with specified id was not found"));
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course putReview(Review review, Long id) {
        Course courseToUpdate = courseRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Course with specified id was not found"));
        courseToUpdate.addReview(review);
        return courseRepository.save(courseToUpdate);
    }
}
