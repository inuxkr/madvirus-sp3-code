package madvirus.spring.chap06.service;

public class ArticleService {

	public void writeArticle(NewArticleCommand command) {
		System.out.println("신규 게시글 등록: " + command);
	}
}
