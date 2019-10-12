package edu.mum.cs.bookrestserver.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class Book {

    private Long id;

    @Size(min=2, max=10, message="Size of title between 2 and 10")
    private String title;

    @NotBlank(message = "cannot be blank")
    private String isbn;

}
