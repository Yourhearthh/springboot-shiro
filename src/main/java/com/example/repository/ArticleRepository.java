package com.example.repository;

import com.example.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @ClassName:
 * @Description:
 * @author: baoguangyu
 * @date: 2021-04-30 13:33
 * @version: 1.0
 */
public interface ArticleRepository extends JpaRepository<Article,Long>, JpaSpecificationExecutor<Article> {
    Article findById(long id);
}
