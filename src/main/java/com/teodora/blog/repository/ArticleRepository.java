package com.teodora.blog.repository;

import com.teodora.blog.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ArticleRepository extends MongoRepository<Article, Integer> {

    @Query("{'title': ?0}")
    List<Article> getArticleByTitle(String title);

    @Query("{'author': ?0}")
    List<Article> getArticleByAuthor(String author);

    @Query("{'tag': ?0}")
    List<Article> getArticleByTag(String tag);

    @Query("{'title': ?0 , 'tag': ?1}")
    List<Article> getArticleByTitleAndTag(String title, String tag);

    @Query("{'title': ?0 , 'author': ?1}")
    List<Article> getArticleByTitleAndAuthor(String title, String author);
}
