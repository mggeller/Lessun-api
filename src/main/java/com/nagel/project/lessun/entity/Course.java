package com.nagel.project.lessun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @SequenceGenerator(name = "my_seq", sequenceName = "seq1", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    private Long id;
    private String tag;
    private String title;
    private Integer duration;
    private Integer students;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "long_description")
    private String longDescription;

    private Long price;
    private Integer rating;

    @Column(name = "picture_path")
    private String picturePath;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "tags",
            joinColumns = @JoinColumn(name = "course_id",
            referencedColumnName = "id")
    )
    private List<Tag> tags = new ArrayList<>();
}
