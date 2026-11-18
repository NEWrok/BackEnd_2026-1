package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import java.util.Collection;
import org.springframework.web.bind.annotation.*;

@Controller
public class ArticleViewController {

    private final ArticleService articleService;

    public ArticleViewController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/posts")
    public String getPosts(Model model) {
        Collection<ArticleDto> articles = articleService.getArticles();

        model.addAttribute("articles", articles);

        return "posts";
    }
}
