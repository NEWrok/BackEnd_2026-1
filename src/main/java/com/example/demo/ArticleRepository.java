package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ArticleRepository {
    private final Map<Long, ArticleDto> db = new ConcurrentHashMap<>();
    private Long idSequence = 1L;

    public Collection<ArticleDto> getAllArticles() {
        return db.values();
    }

    public ArticleDto getArticle(Long id) {
        return db.get(id);
    }

    public Long createArticle(ArticleDto articleDto) {
        Long id = idSequence++;
        db.put(id, articleDto);
        return id;
    }

    public boolean updateArticle(Long id, ArticleDto articleDto) {
        if (!db.containsKey(id)) {
            return false;
        }
        db.put(id, articleDto);
        return true;
    }

    public boolean deleteArticle(Long id) {
        return db.remove(id) != null;
    }

    public boolean isEmpty() {
        return db.isEmpty();
    }

}
