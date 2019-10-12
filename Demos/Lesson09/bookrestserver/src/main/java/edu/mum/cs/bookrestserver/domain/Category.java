package edu.mum.cs.bookrestserver.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@ApiModel(description = "All details about the category.")
public class Category {

    private int id;

    @NotEmpty
    @ApiModelProperty(notes = "Name cannot be empty")
    private String name;

    @Size(min = 8, max = 50, message = "{Size.name.validation}")
    @ApiModelProperty(notes = "Size of description should be between 8 and 16")
    private String description;

    public Category() {
    }

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
    }

}
