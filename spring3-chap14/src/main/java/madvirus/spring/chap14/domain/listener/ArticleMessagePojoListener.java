package madvirus.spring.chap14.domain.listener;

import madvirus.spring.chap14.domain.Article;

public class ArticleMessagePojoListener {

	public void received(Article article) {
		System.out.println("메시지 수신: " + article.getSubject());
	}
}
