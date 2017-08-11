package com.drd.jaas.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

/**
 * Simple console login
 * Created by dr-d on 30/09/15
 */
public class DatabaseLoginApp {

    private final static Logger log = LoggerFactory.getLogger(DatabaseLoginApp.class);

    private static final String JAAS_CONFIG = "jaas.databaseConfig";

    public static void main(String[] args) {
        log.debug("Setting jaas configuration: '{}'", JAAS_CONFIG);
        System.setProperty("java.security.auth.login.config", JAAS_CONFIG);

        new H2DatabaseSetup(); //create the database and users

        LoginContext loginContext;
        try {
            loginContext = new LoginContext("DatabaseConfig", new MyCallbackHandler());
            loginContext.login();
        } catch (LoginException e) {
            e.printStackTrace();
            System.err.println("Login Failure");
            System.exit(-1);
        }
        System.out.println("Logged in");
    }
}