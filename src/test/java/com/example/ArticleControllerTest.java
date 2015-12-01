package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.spring.controllers.ArticleController;
import com.spring.models.Article;
import com.spring.services.ArticleService;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(MockitoJUnitRunner.class)
public class ArticleControllerTest {
    
    private MockMvc mockMvc;
    
    @Mock
    private ArticleService articleServiceMock;
    
    
    @Before
    public void setUp (){
        ArticleController articleController = new ArticleController();
        articleController.setArticleService(articleServiceMock);
        mockMvc = MockMvcBuilders.standaloneSetup(articleController).build();   
    }
    
    @Test
    public void testGet() throws Exception{
        Article article = new Article();
        article.setId(1);
        article.setTitle("hello");
        when(articleServiceMock.get()).thenReturn(article);
        mockMvc.perform(get("/articles/3")).andExpect(status().isOk());
    }
    

}
