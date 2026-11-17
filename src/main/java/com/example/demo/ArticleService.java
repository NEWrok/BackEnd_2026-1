package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Collection<ArticleDto> getArticles() {
        if (articleRepository.isEmpty()) {
            return null;
        }
        return articleRepository.getAllArticles();
    }

    public ArticleDto getArticle(Long id) {
        return articleRepository.getArticle(id);
    }

    public Long createArticle(ArticleDto articleDto) {
        return articleRepository.createArticle(articleDto);
    }

    public boolean updateArticle(Long id, ArticleDto articleDto) {
        return articleRepository.updateArticle(id, articleDto);
    }

    public boolean deleteArticle(Long id) {
        return articleRepository.deleteArticle(id);
    }
}