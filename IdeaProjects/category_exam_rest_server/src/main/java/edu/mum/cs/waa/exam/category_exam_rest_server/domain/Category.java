package edu.mum.cs.waa.exam.category_exam_rest_server.domain;

import javax.validation.constraints.NotBlank;

public class Category {
    @NotBlank
    private String name;
    @NotBlank
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
