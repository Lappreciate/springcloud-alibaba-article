package com.example.blogService.articleService.mapper;

import com.example.blogService.articleService.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
class ArticleMapperTest {

    @Resource
    private ArticleMapper articleMapper;

    @Test
    public void testList() {
        List<Article> articles = articleMapper.findByArticles();
        for (Article article : articles) {
            System.out.println(article.getTitle());
        }
    }

}