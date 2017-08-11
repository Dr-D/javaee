package com.drd.jaas.simple;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

/**
 * Simple console login
 * Created by dr-d on 30/09/15
 */
public class LoginApp {

    public static void main(String[] args) {
        //File to look for the jaas congiguration
        System.setProperty("java.security.auth.login.config", "jaas.consoleConfig");

        LoginContext loginContext;
        try {
            loginContext = new LoginContext("MyConfig", new MyCallbackHandler());//The configuration name
            loginContext.login();
        } catch (LoginException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println("Logged in");
    }
}