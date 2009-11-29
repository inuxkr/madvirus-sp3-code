package kame.spring.chap05.aop.pojo;

import kame.spring.chap05.board.Article;

import org.aspectj.lang.JoinPoint;

public class ArticleReadTraceAdvice {

	public void afterReturning(JoinPoint joinPoint, Article article, Integer articleId) {
	}

}
