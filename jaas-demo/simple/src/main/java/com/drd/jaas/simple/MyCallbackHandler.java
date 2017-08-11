package com.drd.jaas.simple;

import javax.security.auth.callback.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dr-d on 30/09/15
 */
public class MyCallbackHandler implements CallbackHandler {
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        NameCallback nameCallback = (NameCallback)callbacks[0];
        System.err.print(nameCallback.getPrompt());
        String name = new BufferedReader(new InputStreamReader(System.in)).readLine();
        nameCallback.setName(name);

        PasswordCallback passwordCallback = (PasswordCallback)callbacks[1];
        System.err.print(passwordCallback.getPrompt());
        String password = new BufferedReader(new InputStreamReader(System.in)).readLine();
        passwordCallback.setPassword(password.toCharArray());
    }
}
