package madvirus.spring.chap14.domain;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;

public class ArticleMessageReceiver {

	private JmsTemplate jmsTemplate;
	private Destination destination;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Article receive() {
		MapMessage mapMessage = (MapMessage) jmsTemplate.receive(destination);
		Article article = new Article();
		try {
			article.setSubject(mapMessage.getString("subject"));
			return article;
		} catch (JMSException e) {
			throw JmsUtils.convertJmsAccessException(e);
		}
//		Article article = (Article)jmsTemplate.receiveAndConvert(destination);
//		return article;
	}

}
