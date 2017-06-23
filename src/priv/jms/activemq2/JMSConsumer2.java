package priv.jms.activemq2;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class JMSConsumer2 {

	private static final String USERNAME=ActiveMQConnection.DEFAULT_USER; // 默锟较碉拷锟斤拷锟斤拷锟矫伙拷锟斤拷
	private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD; // 默锟较碉拷锟斤拷锟斤拷锟斤拷锟斤拷
	private static final String BROKEURL=ActiveMQConnection.DEFAULT_BROKER_URL; // 默锟较碉拷锟斤拷锟接碉拷址
	
	public static void main(String[] args) {
		ConnectionFactory connectionFactory; 
		Connection connection = null; 
		Session session; 
		Destination destination; 
		MessageConsumer messageConsumer; 
		
		connectionFactory=new ActiveMQConnectionFactory(JMSConsumer2.USERNAME, JMSConsumer2.PASSWORD, JMSConsumer2.BROKEURL);
				
		try {
			connection=connectionFactory.createConnection(); 
			connection.start();
			session=connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE); 
			// destination=session.createQueue("FirstQueue1");  
			destination=session.createTopic("FirstTopic1");
			messageConsumer=session.createConsumer(destination); 
			messageConsumer.setMessageListener(new Listener2());
		} catch (JMSException e) {
			e.printStackTrace();
		} 
	}
}
