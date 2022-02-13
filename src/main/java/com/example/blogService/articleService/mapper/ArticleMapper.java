package com.example.blogService.articleService.mapper;

import com.example.blogService.articleService.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Select("select * from article order by create_time desc")
    List<Article> findByArticleId();
}
