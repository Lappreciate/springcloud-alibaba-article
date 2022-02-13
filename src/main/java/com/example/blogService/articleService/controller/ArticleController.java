package com.example.blogService.articleService.controller;


import com.example.blogService.articleService.entity.Article;
import com.example.blogService.articleService.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ArticleController {

    @Resource
    private ArticleService articleService;


    @GetMapping("/articles")
    public List<Article> findByArticleId(Long articleId) {
        return articleService.findArticles();
    }
}
