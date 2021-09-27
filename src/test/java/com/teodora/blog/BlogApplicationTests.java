package com.teodora.blog;

import com.teodora.blog.controller.ArticleController;
import com.teodora.blog.model.Article;
import com.teodora.blog.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class BlogApplicationTests {
	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private ArticleController articleController;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllArticles() {
		List<Article> article2 = articleController.getAllArticles();
		List<Article> article = articleRepository.findAll();
		assertThat(article2.equals(article));
	}

}
