package com.nagel.project.lessun.controller;

import com.nagel.project.lessun.dto.CourseDTO;
import com.nagel.project.lessun.dto.ReviewDTO;
import com.nagel.project.lessun.entity.Course;
import com.nagel.project.lessun.entity.Review;
import com.nagel.project.lessun.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private ModelMapper modelMapper;

    private final CourseService courseService;

    @GetMapping
    public List<CourseDTO> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    public CourseDTO getCourse(@PathVariable Long id) {
        return courseService.getCourse(id);
    }

    @PostMapping
    public CourseDTO addCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.addCourse(courseDTO);
    }

    @PutMapping("/{id}")
    public CourseDTO updateCourse(@RequestBody ReviewDTO review, @PathVariable Long id) {
        return courseService.putReview(review, id);
    }
}
