package com.spring.services;

import org.springframework.stereotype.Component;

import com.spring.models.Article;

@Component
public class ArticleService {
    
    public Article get(){
        Article article = new Article();
        article.setId(1);
        article.setTitle("hello this is an article");
        return article;
    }

}
