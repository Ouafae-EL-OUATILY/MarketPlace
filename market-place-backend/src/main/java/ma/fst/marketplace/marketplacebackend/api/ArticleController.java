package com.madani.market_place.api;

import com.madani.market_place.model.Article;
import com.madani.market_place.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/article")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping("/add")
    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
        return new ResponseEntity<>(articleService.add(article), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        return new ResponseEntity<>(articleService.update(article), HttpStatus.OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<Article>> getAllArticles() {
        return new ResponseEntity<>(articleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Article> getArticle(@PathVariable("id") Long id) {
        return new ResponseEntity<>(articleService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteArticle(@PathVariable("id") Long id) {
        articleService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
