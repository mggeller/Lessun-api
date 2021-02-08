package com.nagel.project.lessun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    private String tag;
    private String title;
    private Integer duration;
    private String short_description;
    private String long_description;
    private Long price;
    private Integer rating;
    private String picture_path;
}
