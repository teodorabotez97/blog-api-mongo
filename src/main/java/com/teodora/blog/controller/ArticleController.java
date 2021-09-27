package com.teodora.blog.controller;

import com.teodora.blog.exceptions.ArticleNotFoundException;
import com.teodora.blog.model.Article;
import com.teodora.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController

public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles")
    public ResponseEntity<List<Article>> getAllArticles(@RequestParam(required = false) String title) {
        try {
            List<Article> tutorials = new ArrayList<Article>();

            if (title == null)
                articleRepository.findAll().forEach(tutorials::add);
            else
                articleRepository.findByTitleContaining(title).forEach(tutorials::add);

            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getTutorialById(@PathVariable("id") Integer id) {
        Optional<Article> articleData = articleRepository.findById(id);

        if (articleData.isPresent()) {
            return new ResponseEntity<>(articleData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/articles/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") Integer id) {
        try {
            articleRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/articles/{id}")
    public ResponseEntity<Article> updateTutorial(@PathVariable("id") Integer id, @RequestBody Article updatedArticle) {
        Optional<Article> articleData = articleRepository.findById(id);

        if (articleData.isPresent()) {
            Article article = articleData.get();
            article.setTitle(updatedArticle.getTitle());
            article.setTag(updatedArticle.getTag());
            article.setAuthor(updatedArticle.getAuthor());
            article.setDate(updatedArticle.getDate());

            return new ResponseEntity<>(articleRepository.save(article), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/articles")
    public ResponseEntity<Article> createArticle(@RequestBody Article article) {
        try {
            Article _article = articleRepository.save(new Article(article.getId(),article.getTitle(), article.getTag(),article.getAuthor(),
                    article.getDate(),article.getImgUrl(),article.getContent(),article.getDateTimestamp()));
            return new ResponseEntity<>(_article, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/searchArticleByTitle")
    public ResponseEntity<List<Article>> getArticleByTitle(@Param("title") String title) {
        try {
            List<Article> articles = articleRepository.getArticleByTitle(title);

            if (articles.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(articles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
