package com.example.blogService.articleService.controller;


import com.example.blogService.articleService.annotation.JwtToken;
import com.example.blogService.articleService.dto.ResponseObject;
import com.example.blogService.articleService.entity.Article;
import com.example.blogService.articleService.entity.Video;
import com.example.blogService.articleService.feignClient.VideoFeignClient;
import com.example.blogService.articleService.service.ArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @JwtToken
    @RequestMapping("/doSth")
    public ResponseObject<Map> doSth(String username, String password) {
        ResponseObject<Map> responseObject = null;
        try {

            return responseObject;
        } catch (Exception e) {
            e.printStackTrace();
            return responseObject;
        }
    }

    @GetMapping("/articles")
    public List<Article> findArticles() {
        return articleService.findArticles();
    }


    @GetMapping("/list")
    public ResponseObject<Video> findByArticleId() {
        return new ResponseObject<>("0", "success", articleService.findByArticleId(1648L).getData());
    }
}
