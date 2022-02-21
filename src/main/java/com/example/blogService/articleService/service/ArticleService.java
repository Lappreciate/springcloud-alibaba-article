package com.example.blogService.articleService.service;

import com.example.blogService.articleService.dto.ResponseObject;
import com.example.blogService.articleService.entity.Article;
import com.example.blogService.articleService.entity.Video;
import com.example.blogService.articleService.feignClient.VideoFeignClient;
import com.example.blogService.articleService.mapper.ArticleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
public class ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private VideoFeignClient videoFeignClient;

    public List<Article> findArticles() {
        return articleMapper.findByArticles();
    }

    public ResponseObject<Video> findByArticleId(Long articleId) {
        return videoFeignClient.findByArticleId(articleId);
    }
}
