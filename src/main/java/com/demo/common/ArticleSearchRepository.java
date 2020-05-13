package com.demo.common;

import com.demo.pojo.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long> {
    public Article queryArticleById(Long id);
}
