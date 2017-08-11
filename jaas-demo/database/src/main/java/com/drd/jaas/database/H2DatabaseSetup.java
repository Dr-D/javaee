package com.drd.jaas.database;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by dr-d on 01/10/15
 */
public class H2DatabaseSetup {

    private final static Logger log = LoggerFactory.getLogger(H2DatabaseSetup.class);

    public H2DatabaseSetup() {
        setUpDatabase();
    }

    private void setUpDatabase() {
        H2DatabaseConnector connector = new H2DatabaseConnector();
        Connection connection = connector.getDBConnection();
        try {
            Statement statement = connection.createStatement();
            log.debug("Creating table USER");
            statement.execute("DROP TABLE IF EXISTS USER");
            statement.execute("CREATE TABLE USER(USER_ID INT IDENTITY, USER_NAME VARCHAR(20) UNIQUE, USER_PASSWORD VARCHAR(20))");
            statement.execute("INSERT INTO USER VALUES(1, 'drd', 'password')");
            statement.execute("INSERT INTO USER VALUES(2, 'User1', 'Password1')");
            statement.execute("INSERT INTO USER VALUES(3, 'mickey', 'mouse')");

            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS USER_COUNT FROM USER");
            resultSet.next();
            int userCount = resultSet.getInt("USER_COUNT");
            log.debug("USER_COUNT: '{}'", userCount);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
