package kame.spring.chap05.board.dao;

import kame.spring.chap05.board.Article;

public class MySQLArticleDao implements ArticleDao {

	@Override
	public void insert(Article article) {
		System.out.println("MySQLArticleDao.insert() ½ÇÇà");
	}

}
