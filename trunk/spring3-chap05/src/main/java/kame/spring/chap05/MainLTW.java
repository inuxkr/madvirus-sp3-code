package kame.spring.chap05;

import kame.spring.chap05.board.Article;
import kame.spring.chap05.board.service.ArticleNotFoundException;
import kame.spring.chap05.board.service.ReadArticleService;
import kame.spring.chap05.board.service.ReadArticleServiceImpl;
import kame.spring.chap05.board.service.WriteArticleService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainLTW {

	public static void main(String[] args) throws ArticleNotFoundException {
		String[] configLocations = new String[] { "acLTW.xml" };
		ApplicationContext context = new ClassPathXmlApplicationContext(
				configLocations);

		ReadArticleService readArticleService = new ReadArticleServiceImpl();
		readArticleService.getArticleAndIncreaseReadCount(10);
		
		WriteArticleService writeArticleService = context.getBean(
				"writeArticleService", WriteArticleService.class);
		writeArticleService.write(new Article());
		
		Article article = new Article();
		article.increaseReadCount();
	}
}
