package com.example.employeemanager.model;

import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name="lab_posts", schema = "hinga")
public class Posts implements Serializable {

    @Id
    private Integer id;
    @Column(name="user_id")
    private Integer userId;
    @Column(name="title")
    private String titleP;
    @Column(name="body")
    private String bodyP;
    @Column(name="is_comentable")
    private Boolean isComentable;

    private LocalDateTime created;

    private LocalDateTime updated;




}
