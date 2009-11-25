package kame.spring.chap05.board.service;

import kame.spring.chap05.board.Article;
import kame.spring.chap05.board.dao.ArticleDao;

public class WriteArticleServiceImpl implements WriteArticleService {

    private ArticleDao articleDao;

    public WriteArticleServiceImpl(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public void write(Article article) {
        System.out.println("WriteArticleServiceImpl.write() 메서드 실행");
        articleDao.insert(article);
    }

}
