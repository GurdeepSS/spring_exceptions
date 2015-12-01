package com.spring.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exceptions.ArticleNotFoundException;
import com.spring.models.Article;
import com.spring.services.ArticleService;

/**
 * Articles Rest Controller
 * Articles controller is an example of handling exception per controller
 * where the exception handler is inside the controller
 * @author ahmad.bakr
 *
 */
@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    
    private Article article;

    public ArticleController() {
        this.article = new Article();
        article.setId(1);
        article.setTitle("Welcome to Spring Exceptions");
    }

    /**
     * Get Article by id
     * This is an example of handling exceptions per controller. When the exception is
     * thrown, it is caught by @see handleArticleNotFoundException which is responsible for
     * the way to handle this exception
     * @param id article id
     * @return an article if the id matches; otherwise throws an exception
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Article get(@PathVariable(value = "id") int id) {
        if (id > 0) {
            return articleService.get();
        }
        throw new ArticleNotFoundException(id);
    }

    /**
     * Handle ArticleNotFoundException thrown by this controller 
     * @param ex ArticleNotFoundException
     * @return HashMap containing the error response
     */
    @ExceptionHandler(ArticleNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public Map<String, String> handleArticleNotFoundException(ArticleNotFoundException ex) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("id", String.valueOf(ex.getId()));
        map.put("reason", "Article not found.");
        return map;
    }
    
    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
}
