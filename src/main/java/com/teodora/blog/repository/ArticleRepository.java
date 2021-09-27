package com.teodora.blog.repository;

import com.teodora.blog.model.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ArticleRepository extends MongoRepository<Article, Integer> {
    List<Article> findByTitleContaining(String title);
    List<Article> getArticleByTitle(String title);

}
