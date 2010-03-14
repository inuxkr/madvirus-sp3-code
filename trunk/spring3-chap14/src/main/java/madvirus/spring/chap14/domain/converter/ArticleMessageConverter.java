package madvirus.spring.chap14.domain.converter;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import madvirus.spring.chap14.domain.Article;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

public class ArticleMessageConverter implements MessageConverter {

	@Override
	public Object fromMessage(Message message) throws JMSException,
			MessageConversionException {
		MapMessage mapMessage = (MapMessage) message;
		Article article = new Article();
		article.setSubject(mapMessage.getString("subject"));
		return article;
	}

	@Override
	public Message toMessage(Object object, Session session)
			throws JMSException, MessageConversionException {
		Article article = (Article) object;
		MapMessage mapMessage = session.createMapMessage();
		mapMessage.setString("subject", article.getSubject());
		return mapMessage;
	}

}
