package com.drd.jaas.simple;

import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by dr-d on 30/09/15
 */
public class MyLoginModule implements LoginModule {

    private Subject subject;
    private CallbackHandler callbackHandler;
    private Map<String, ?> sharedState;
    private Map<String, ?> options;
    private boolean succeeded;

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        succeeded = false;
        this.subject = subject;
        this.callbackHandler = callbackHandler;
        this.sharedState = sharedState;
        this.options = options;
    }

    @Override
    public boolean login() throws LoginException {
        NameCallback nameCallback = new NameCallback("Name: ");
        PasswordCallback passwordCallback = new PasswordCallback("Password: ", false);

        try {
            callbackHandler.handle(new Callback[]{nameCallback, passwordCallback});
        } catch (IOException | UnsupportedCallbackException e) {
            e.printStackTrace();
        }

        String name = nameCallback.getName();
        char[] password = passwordCallback.getPassword();
        if(name.equals("admin") && Arrays.equals(new char[]{'p','a','s','s','w','o','r','d'}, password))
            succeeded =true;
        return succeeded;
    }

    @Override
    public boolean commit() throws LoginException {
        return succeeded;
    }

    @Override
    public boolean abort() throws LoginException {
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        return false;
    }
}
