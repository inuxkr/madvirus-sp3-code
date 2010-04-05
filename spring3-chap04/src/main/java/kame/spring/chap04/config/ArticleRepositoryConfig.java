package kame.spring.chap04.config;

import kame.spring.chap04.article.ArticleRepository;
import kame.spring.chap04.article.ArticleRepositoryImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArticleRepositoryConfig {

	@Bean
	public ArticleRepository articleRepository() {
		return new ArticleRepositoryImpl();
	}
}
