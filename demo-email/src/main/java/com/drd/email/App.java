package com.drd.email;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

/**
 * @author drd - 2017-09-08.
 */
public class App {

    public static void main(String[] args) {

        try {
            Properties properties = new Properties();
            properties.put("mail.imap.host", "host");
            properties.put("mail.imap.port", "143");

            Session emailSession = Session.getDefaultInstance(properties);

            Store store = emailSession.getStore("imap");
            store.connect("host", "user", "password");

            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                String subject = message.getSubject();
                File file = new File(subject);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                message.writeTo(fileOutputStream);
                fileOutputStream.close();
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());
            }

            emailFolder.close(false);
            store.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


