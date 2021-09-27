package com.teodora.blog.repository;

import com.teodora.blog.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface ArticleRepository extends MongoRepository<Article, Integer> {

    @Query("{'title': ?0}")
    List<Article> getArticleByTitle(String title);

}
