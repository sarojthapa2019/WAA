package edu.mum.cs.waa.exam.exampractice.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private Integer id;
    @NotBlank(message = "Category cannot be blank")
    private String categoryName;

}
