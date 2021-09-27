package com.teodora.blog.repository;

import com.teodora.blog.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Query("Select a from Article a  where a.title like ?1%")
    Article getArticleByTitle(String title);

    @Query("Select a from Article a  where a.author like ?1%")
    List<Article> getArticleByAuthor(String author);

    @Query("Select a from Article a  where a.tag like ?1%")
    Article getArticleByTag(String tag);

    @Query("Select a from Article a where a.title like ?1% and a.tag like ?2%")
    Article getArticleByTitleAndTag(String title, String tag);

    @Query("Select a from Article a  where a.title like ?1% and a.author like ?2%")
    Article getArticleByTitleAndAuthor(String title, String author);
}
