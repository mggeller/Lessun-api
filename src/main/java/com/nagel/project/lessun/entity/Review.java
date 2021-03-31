package com.nagel.project.lessun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reviews")
public class Review {

    /*@Id
    @GeneratedValue
    private Long id;*/

    @Column(name = "user_name")
    private String userName;

    @Column(name = "feed_back")
    private String feedBack;
}
