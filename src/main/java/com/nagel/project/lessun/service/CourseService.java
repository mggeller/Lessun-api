package com.nagel.project.lessun.service;

import com.nagel.project.lessun.dto.CourseDTO;
import com.nagel.project.lessun.dto.ReviewDTO;
import com.nagel.project.lessun.entity.Course;
import com.nagel.project.lessun.entity.Review;
import com.nagel.project.lessun.repository.ICourseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CourseService {

    @Autowired
    private ModelMapper modelMapper;

    private final ICourseRepository courseRepository;

    public List<CourseDTO> getCourses() {
        return courseRepository.findAll().stream()
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
    }

    public CourseDTO getCourse(Long id) {
        return courseRepository.findById(id).map(course1 -> modelMapper.map(course1, CourseDTO.class)).orElseThrow(() ->
                new RuntimeException("Course with specified id was not found"));
    }

    public CourseDTO addCourse(CourseDTO courseDTO) {

        Course course = modelMapper.map(courseDTO, Course.class);
        return modelMapper.map(courseRepository.save(course), CourseDTO.class);
    }

    public CourseDTO putReview(ReviewDTO reviewDTO, Long id) {
        Review review = modelMapper.map(reviewDTO, Review.class);
        Course courseToUpdate = courseRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Course with specified id was not found"));
        courseToUpdate.addReview(review);
        return modelMapper.map(courseRepository.save(courseToUpdate), CourseDTO.class);
    }
}
