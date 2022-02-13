package com.example.blogService.articleService.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Article {
    private Long articleId;
    private String title;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createName;

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateName() {
        return createName;
    }

    public void setCreateName(Date createName) {
        this.createName = createName;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createName=" + createName +
                '}';
    }
}
