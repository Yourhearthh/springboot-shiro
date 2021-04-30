package com.example.service;

import com.example.entity.Article;

import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2021-04-30 13:33
 * @version: 1.0
 */
public interface ArticleService {
    public List<Article> getArticleList();

    public Article findArticleById(long id);
}
