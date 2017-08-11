package com.drd.mdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;
import java.io.FileOutputStream;

/**
 * Created by drd on 15/09/15
 */
@MessageDriven(name = "HelloWorldQueueMDB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/queue/demoQueue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "AUTO_ACKNOWLEDGE")})
public class QueueMDB implements MessageListener {

    private final static Logger log = LoggerFactory.getLogger(QueueMDB.class);

    private static int count  = 0;

    public void onMessage(Message message) {
        count ++;
        BytesMessage bytesMessage;
        try {
            if (message instanceof BytesMessage) {
                bytesMessage = (BytesMessage) message;

                log.info("Received ByteMessage from queue");
                long bodyLength = bytesMessage.getBodyLength();
                byte[] buffer = new byte[(int)bodyLength];
                bytesMessage.readBytes(buffer);

                FileOutputStream fileOutputStream = new FileOutputStream("/home/drd/Applications/MDB/test" + count + ".pdf");
                fileOutputStream.write(buffer);
                fileOutputStream.close();

                log.info("Saved message");
            } else {
                log.error("Invalid message type: '{}'", message.getClass().getName());
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
