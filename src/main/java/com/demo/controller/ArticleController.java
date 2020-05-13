package com.demo.controller;


import com.demo.pojo.Article;
import com.demo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文章Controller
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @RequestMapping("/add")
    public String add(Article article) throws Exception {
        try{
            articleService.add(article);
            return "success";
        }catch(Exception e){
            return "fail";
        }
    }

    @RequestMapping("/delete")
    public String delete(Article article) throws Exception {
        try{
            articleService.delete(article);
            return "success";
        }catch(Exception e){
            return "fail";
        }
    }

    @RequestMapping("/update")
    public String update(Article article) throws Exception {
        try{
            articleService.update(article);
            return "success";
        }catch(Exception e){
            return "fail";
        }
    }

    @RequestMapping("/queryArticleById")
    public Article queryArticleById(Long id) throws Exception {
        try{
            return articleService.queryArticleById(id);
        }catch(Exception e){
            return null;
        }
    }

    @RequestMapping("/fuzzyQueryArticleByTitle")
    public List<Article> fuzzyQueryArticleByTitle(String string) throws Exception {
        try{
            return articleService.fuzzyQueryArticleByTitle(string);
        }catch(Exception e){
            return null;
        }
    }
}
