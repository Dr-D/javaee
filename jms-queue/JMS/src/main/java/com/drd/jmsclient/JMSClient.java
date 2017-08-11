package com.drd.jmsclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Properties;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 * Created by drd on 15/09/15
 */
public class JMSClient {
    private static final Logger log = LoggerFactory.getLogger(JMSClient.class);

    public static void main(String[] args) throws Exception {

        Connection connection = null;
        Context context = null;
        try {
            final Properties properties = new Properties();
            properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            properties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            context = new InitialContext(properties);

            ConnectionFactory connectionFactory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");
            log.info("Found connection factory in JNDI");

            Destination destination = (Destination) context.lookup("java:/jms/queue/demoQueue");
            log.info("Found destination in JNDI");

            //get connection
            connection = connectionFactory.createConnection("drd", "password");
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination);

            connection.start();

            int messageCount = 200;
            for (int i = 0; i < messageCount; i++) {
                if(i % 100 == 0) {
                    log.info("Sending message: {}/{}", i, messageCount);
                }

                FileToBytes fileToBytes = new FileToBytes();
                BytesMessage message = session.createBytesMessage();

                message.writeBytes(fileToBytes.getBytes());
                producer.send(message);
            }
        } catch (Exception e) {
            log.error("Error on queue", e);
        } finally {
            if (context != null) {
                context.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
