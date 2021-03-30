package com.nagel.project.lessun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Table(name = "tags")
public class Tag {

    /*@Id
    @GeneratedValue
    private Long id;*/

    @Column(name = "tag_name")
    private String tagName;
    private String Description;
}
