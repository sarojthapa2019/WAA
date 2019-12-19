package edu.mum.cs.waa.exam.exampractice.domain;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "mybook")
@Table(name = "ybook")
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookId")
    private Long id;

    @NotBlank(message = "Name cannot be blank..")
    private String name;
    @NotBlank(message = "Author cannot be blank")
    private String Author;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId")
    @Fetch(FetchMode.JOIN)
    List<Category> categoryList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "bookId")

    List<Review> reviewList;

    public void addReview(Review review){
        reviewList.add(review);
    }
}
