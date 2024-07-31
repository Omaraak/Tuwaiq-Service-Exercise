package com.example.week5day4serviceexercise.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Article {
    @NotEmpty(message = "id can't be empty")
    private String id;

    @NotEmpty(message = "title can't be empty")
    @Size(max = 100, message = "title length can't exceed 100 chars")
    private String title;

    @NotEmpty(message = "author can't be empty")
    @Size(min = 5, max = 20, message = "")
    private String author;

    //Need to change the min to 201
    @NotEmpty(message = "content can't be empty")
    @Size(min = 10, message = " ")
        private String content;

    @NotEmpty(message = "category can't be empty")
    @Pattern(regexp = "(politics|sports|technology)")
    private String category;

    @NotEmpty(message = "imageUrl can't be empty")
    private String imageUrl;

    @AssertFalse
    private boolean isPublished;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate publishDate;
}
