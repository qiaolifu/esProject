package com.demo.service.impl;

import com.demo.common.ArticleSearchRepository;
import com.demo.pojo.Article;
import com.demo.service.ArticleService;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章serviceImpl
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleSearchRepository articleSearchRepository;

    @Autowired
    public ArticleServiceImpl(ArticleSearchRepository articleSearchRepository) {
        this.articleSearchRepository = articleSearchRepository;
    }

    @Override
    public String add(Article article) {

        try {
            articleSearchRepository.save(article);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "defeated";
        }
    }

    @Override
    public String delete(Article article) {
        try {
            articleSearchRepository.delete(article);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "defeated";
        }
    }

    @Override
    public String update(Article article) {
        try {
            articleSearchRepository.save(article);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "defeated";
        }
    }

    @Override
    public Article queryArticleById(Long id) {
        return articleSearchRepository.queryArticleById(id);
    }

    @Override
    public List<Article> fuzzyQueryArticleByTitle(String string) {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        builder.withQuery(QueryBuilders.fuzzyQuery("title",string));
        List<Article> articles = new ArrayList<>();
        for (Article article : articleSearchRepository.search(builder.build())){
            articles.add(article);
        }
        return articles;
    }
}