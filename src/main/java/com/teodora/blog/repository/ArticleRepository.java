package com.teodora.blog.repository;

import com.teodora.blog.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


public interface ArticleRepository extends MongoRepository<Article, Integer> {
    List<Article> findByTitleContaining(String title);
    
    @Query("Select a from Article a  where a.title like ?1%")
    List<Article> getArticleByTitle(String title);

}
