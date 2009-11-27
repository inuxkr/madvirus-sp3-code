package kame.spring.chap05.board.service;

import kame.spring.chap05.board.Article;

public interface ReadArticleService {

	Article getArticleAndIncreaseReadCount(int id)
			throws ArticleNotFoundException;
}
