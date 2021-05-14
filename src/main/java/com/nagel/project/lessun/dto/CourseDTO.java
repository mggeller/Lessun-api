package com.nagel.project.lessun.dto;

import com.nagel.project.lessun.entity.Review;
import com.nagel.project.lessun.entity.Tag;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CourseDTO {
    private Long id;
    private String tag;
    private String title;
    private Integer duration;
    private Integer students;
    private String shortDescription;
    private String longDescription;
    private Long price;
    private Integer rating;
    private String picturePath;
    private List<Tag> tags = new ArrayList<>();
    private List<ReviewDTO> reviews = new ArrayList<>();
}
