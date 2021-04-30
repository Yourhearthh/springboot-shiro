package com.example.service.impl;

import com.example.entity.Article;
import com.example.repository.ArticleRepository;
import com.example.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2021-04-30 13:33
 * @version: 1.0
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    /**
     * Description: 重写service接口的实现，实现列表功能
     */
    @Override
    public List<Article> getArticleList() {
        return articleRepository.findAll();
    }

    /**
     * Description: 重写service接口的实现，实现根据id查询对象功能。
     */
    @Override
    public Article findArticleById(long id) {
        return articleRepository.findById(id);
    }
}
