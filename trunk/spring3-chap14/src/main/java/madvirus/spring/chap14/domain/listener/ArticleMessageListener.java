package madvirus.spring.chap14.domain.listener;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import madvirus.spring.chap14.domain.Article;

import org.springframework.jms.support.JmsUtils;

public class ArticleMessageListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		MapMessage mapMessage = (MapMessage) message;
		try {
			Article article = new Article();
			article.setSubject(mapMessage.getString("subject"));
			processReceiveArtice(article);
		} catch (JMSException e) {
			throw JmsUtils.convertJmsAccessException(e);
		}
	}

	private void processReceiveArtice(Article article) {
		System.out.println("Article 색인 처리 요청:" + article.getSubject());
	}

}
