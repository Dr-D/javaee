package com.drd.jaas.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.callback.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dr-d on 30/09/15
 */
public class MyCallbackHandler implements CallbackHandler {

    private final static Logger log = LoggerFactory.getLogger(MyCallbackHandler.class);

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        log.debug("Name callback called");
        NameCallback nameCallback = (NameCallback)callbacks[0];
        System.err.print(nameCallback.getPrompt());
        String name = new BufferedReader(new InputStreamReader(System.in)).readLine();
        nameCallback.setName(name);

        log.debug("Password callback called");
        PasswordCallback passwordCallback = (PasswordCallback)callbacks[1];
        System.err.print(passwordCallback.getPrompt());
        String password = new BufferedReader(new InputStreamReader(System.in)).readLine();
        passwordCallback.setPassword(password.toCharArray());
    }
}
