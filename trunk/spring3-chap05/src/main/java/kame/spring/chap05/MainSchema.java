package kame.spring.chap05;

import kame.spring.chap05.board.Article;
import kame.spring.chap05.board.service.ArticleNotFoundException;
import kame.spring.chap05.board.service.ReadArticleService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSchema {

	public static void main(String[] args) {
		String[] configLocations = new String[] { "acSchema.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(
				configLocations);

		ReadArticleService readArticleService = context.getBean(
				"readArticleService", ReadArticleService.class);
		try {
			Article article1 = readArticleService
					.getArticleAndIncreaseReadCount(1);
			Article article2 = readArticleService
					.getArticleAndIncreaseReadCount(1);
			System.out.println("article1 == article2 : "
					+ (article1 == article2));
			readArticleService.getArticleAndIncreaseReadCount(0);
		} catch (ArticleNotFoundException e) {
		}
	}
}
