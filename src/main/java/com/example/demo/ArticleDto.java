package com.example.demo;

import java.time.LocalDateTime;

public class ArticleDto {
    private String title;
    private String author;
    private LocalDateTime date;
    private String content;

    public ArticleDto(){
        LocalDateTime date=LocalDateTime.now();
        this.date=date;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }
}