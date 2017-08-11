package com.drd.jaas.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by dr-d on 02/10/15
 */
public class DatabaseAuthenticator {

    private final static Logger log = LoggerFactory.getLogger(DatabaseAuthenticator.class);

    private Map<String, ?> jaasOptions;

    public DatabaseAuthenticator(Map<String, ?> jaasOptions) {
        this.jaasOptions = jaasOptions;
        log.debug("Options: '{}'", jaasOptions);
    }

    public boolean authenticate(String userName, char[] password) {
        H2DatabaseConnector connector = new H2DatabaseConnector();
        Connection connection = connector.getDBConnection((String) jaasOptions.get("url"),
                (String) jaasOptions.get("username"), (String) jaasOptions.get("password"));
        Statement statement;
        String userPassword = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT USER_PASSWORD FROM USER WHERE USER_NAME='" + userName + "'");
            resultSet.next();
            userPassword = resultSet.getString("USER_PASSWORD");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        log.debug("Authenticating user: '{}'", userName);
        return (userPassword != null &&
                Arrays.equals(userPassword.toCharArray(), password));
    }
}
