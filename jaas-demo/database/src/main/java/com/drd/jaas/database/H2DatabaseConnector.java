package com.drd.jaas.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by dr-d on 01/10/15
 */
public class H2DatabaseConnector {

    private final static Logger log = LoggerFactory.getLogger(H2DatabaseConnector.class);

    public Connection getDBConnection() {
        log.debug("Getting default database connection");
        Connection connection = null;
        try {
            //Creates/Connects to H2 database file in project root directory
            connection = DriverManager.getConnection("jdbc:h2:./authenticate", "sa", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public Connection getDBConnection(String url, String dbUsername, String dbPassword) {
        log.debug("Getting database connection: '{}'", url);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, dbUsername, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}