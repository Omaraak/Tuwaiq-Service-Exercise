package com.example.week5day4serviceexercise.Controller;

import com.example.week5day4serviceexercise.Api.ApiResponse;
import com.example.week5day4serviceexercise.Model.Article;
import com.example.week5day4serviceexercise.Service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ams")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/getAll")
    public ResponseEntity getAll() {
        if (articleService.getArticles().isEmpty())
            return ResponseEntity.status(404).body(new ApiResponse("There are no articles in the database"));
        return ResponseEntity.status(200).body(articleService.getArticles());
    }

    @PostMapping("/add")
    public ResponseEntity add(@Valid@RequestBody Article article, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        articleService.addArticle(article);
        return ResponseEntity.status(201).body(new ApiResponse("Article added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable String id, @Valid@RequestBody Article article, Errors errors) {
        if (errors.hasErrors()) {
            String errorMessage = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(errorMessage);
        }
        if (articleService.updateArticle(id, article))
            return ResponseEntity.status(200).body(new ApiResponse("Article updated successfully"));
        return ResponseEntity.status(404).body(new ApiResponse("Article not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        if (articleService.deleteArticle(id))
            return ResponseEntity.status(200).body(new ApiResponse("Article deleted successfully"));
        return ResponseEntity.status(404).body(new ApiResponse("Article not found"));
    }

    @PutMapping("/publish/{id}")
    public ResponseEntity publishArticle(@PathVariable String id) {
        if (articleService.publishArticle(id))
            return ResponseEntity.status(200).body(new ApiResponse("Article published successfully"));
        return ResponseEntity.status(404).body(new ApiResponse("Article not found"));
    }

    @GetMapping("/getPublished")
    public ResponseEntity getPublished() {
        if (articleService.getPublishedArticles().isEmpty())
            return ResponseEntity.status(404).body(new ApiResponse("There are no articles published"));
        return ResponseEntity.status(200).body(articleService.getPublishedArticles());
    }

    @GetMapping("/getByCategory/{category}")
    public ResponseEntity getByCategory(@PathVariable String category) {
        if (articleService.getArticlesByCategory(category).isEmpty())
            return ResponseEntity.status(404).body(new ApiResponse("There are no articles by this category"));

        return ResponseEntity.status(200).body(articleService.getArticlesByCategory(category));
    }

}
