package com.madani.market_place.service;

import com.madani.market_place.exception.ArticleNotFoundException;
import com.madani.market_place.model.Article;
import com.madani.market_place.repository.ArticleRepo;
import com.madani.market_place.service.util.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService implements BaseService<Article> {
    private final ArticleRepo articleRepo;

    @Override
    public Article add(Article article) {
        return articleRepo.save(article);
    }

    @Override
    public Article update(Article article) {
        return articleRepo.save(article);
    }

    @Override
    public List<Article> findAll() {
        return articleRepo.findAll();
    }

    @Override
    public Article findById(Long id) {
        return articleRepo.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException("article by id " + id + " not found"));
    }

    @Override
    public void delete(Long id) {
        articleRepo.deleteById(id);
    }
}
