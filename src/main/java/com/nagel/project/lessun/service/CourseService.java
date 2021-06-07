package com.nagel.project.lessun.service;

import com.nagel.project.lessun.dto.CourseDTO;
import com.nagel.project.lessun.dto.ReviewDTO;
import com.nagel.project.lessun.dto.SearchField;
import com.nagel.project.lessun.entity.Course;
import com.nagel.project.lessun.entity.Review;
import com.nagel.project.lessun.repository.ICourseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CourseService {

    @Autowired
    private ModelMapper modelMapper;

    private final ICourseRepository courseRepository;
    private SearchField searchField = new SearchField("");

    public List<CourseDTO> getCourses() {

        /* System.out.println(this.searchField.getCourseTitle() + " gc1");

        System.out.println(courseRepository.findCoursesByTitle(this.searchField.getCourseTitle()).stream()
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList()) + " gc2"); */

        return courseRepository.findCoursesByTitle(this.searchField.getCourseTitle()).stream()
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
    }

    public CourseDTO getCourse(Long id) {
        return courseRepository.findById(id).map(course1 -> modelMapper.map(course1, CourseDTO.class)).orElseThrow(() ->
                new RuntimeException("Course with specified id was not found"));
    }

    public void searchByTitle(SearchField searchField) {
        // System.out.println(this.searchField.getCourseTitle() + " sbt1");
        this.searchField = searchField;
        // System.out.println(this.searchField.getCourseTitle() + " sbt2");
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
