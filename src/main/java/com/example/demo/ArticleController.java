package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    public ResponseEntity<Collection<ArticleDto>> getArticles(){
        Collection<ArticleDto> articles = articleService.getArticles();
        if (articles.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable Long id) {
        ArticleDto article = articleService.getArticle(id);
        if (article == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(article);
    }

    @PostMapping
    public ResponseEntity<Long> createArticle(@RequestBody ArticleDto articleDto) {
        Long id = articleService.createArticle(articleDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateArticle(@RequestBody ArticleDto articleDto, @PathVariable Long id) {
        boolean isUpdated = articleService.updateArticle(id, articleDto);
        if (!isUpdated) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Article not found");
        }
        return ResponseEntity.ok("Successfully updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteArticle(@PathVariable Long id) {
        boolean isDeleted = articleService.deleteArticle(id);
        if (!isDeleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Article not found");
        }
        return ResponseEntity.ok("Successfully deleted");
    }
}