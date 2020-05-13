package com.demo.service;


import com.demo.pojo.Article;

import java.util.List;

/**
 * 文章service
 */
public interface ArticleService {

    //增加
    public String add(Article article);

    //删除
    public String delete(Article article);

    //局部更新
    public String update(Article article);

    //id查询
    public Article queryArticleById(Long id);

    //标题模糊查询
    public List<Article> fuzzyQueryArticleByTitle(String string);
}
