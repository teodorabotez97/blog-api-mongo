package com.teodora.blog.controller;

import com.teodora.blog.exceptions.ArticleNotFoundException;
import com.teodora.blog.model.Article;
import com.teodora.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping
    public String displayHello(){
        return "Hello";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/articles")
    public List<Article> getAllArticles(){
        return articleRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/articles/{id}")
    public ResponseEntity<Article> getArticlesById(@PathVariable(value = "id") Integer articleId)
      throws ArticleNotFoundException {
        Article article =articleRepository
                            .findById(articleId)
                            .orElseThrow(() -> new ArticleNotFoundException(articleId));
            return ResponseEntity.ok().body(article);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/articles/{id}")
    public void deleteEArticle(@PathVariable(value = "id") Integer articleId) {
        articleRepository.deleteById(articleId);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/articles/{id}")
    public Article updateArticle(@PathVariable(value = "id") Integer articleId, @RequestBody Article articleDetails)
            throws ArticleNotFoundException {

        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ArticleNotFoundException(articleId));
        article.setTitle(articleDetails.getTitle());
        article.setTag(articleDetails.getTag());
        article.setAuthor(articleDetails.getAuthor());
        article.setDate(articleDetails.getDate());
        article.setImgUrl(articleDetails.getImgUrl());
        article.setContent(articleDetails.getContent());
        return articleRepository.save(article);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/articles")
    public Article newArticle(@RequestBody Article newArticle){
        return articleRepository.save(newArticle);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/searchArticleByAuthor")
    public List<Article> getArticleByAuthor(@Param("author")String author){

        return articleRepository.getArticleByAuthor(author);
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/searchArticleByTitle")
    public Article getArticleByTitle(@Param("title") String title){
        return articleRepository.getArticleByTitle(title); }

    @CrossOrigin(origins = "*")
    @GetMapping("/searchArticleByTag")
    public Article getArticleByTag(@Param("tag") String tag){

        return articleRepository.getArticleByTag(tag);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/searchArticleByTitleAndTag")
    public Article getArticleByTitleAndTag(@Param("title") String title, @Param("tag")  String tag){

        return articleRepository.getArticleByTitleAndTag(title,tag);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/searchArticleByTitleAndAuthor")
    public Article getArticleByTitleAndAuthor(@Param("title") String title, @Param("author") String author){

        return articleRepository.getArticleByTitleAndAuthor(title,author);
    }

}
