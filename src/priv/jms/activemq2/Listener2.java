package priv.jms.activemq2;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


public class Listener2 implements MessageListener{

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("TextMessage:"+((TextMessage)message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
