# liquibase basic-demo

Liquibase updates an SQL schema and makes sure there is a log of the changes applied. 

This module shows how to set up liquibase plugin in a maven project and how to use basic liquibase commands.

## pom.xml
Check the liquibase-maven-plugin in the pom.xml file.
Requires the properties file and changelog file in the configuration section.

## resources
This contains the liquibase configuration files.
The properties file has the connection parameters for mysql database.

When the basic-demo module is compiled `mvn compile` a target/classes directory is created.
The files should be copied from the resources directory to this directory and are then made available to the plugin.

## mysql server
Make sure you have mysql server installed on your machine and the the liquibase.properties file contains the correct values to allow the plugin to connect to the database.

Create an empty database testdb in this case for the schema changes to be applied to.

## liquibase mvn commands
Open a command line and change directory to `basic-demo`.

`mvn compile` will create the target directory with the correct resources available as noted above.

`mvm liquibase:status` should show:
``` 
[INFO] Executing on Database: jdbc:mysql://localhost:3306/testdb
   2 change sets have not been applied to root@localhost@jdbc:mysql://localhost:3306/testdb
        db-changelog-1.0.xml::create_person::drd
        db-changelog-1.0.xml::tag-1.0::drd
```

It has found the resource files and is indicating that the two <changeSet> sets have not been applied.

`mvm liquibase:update` should indicate that Table PERSON has been created and the Tag 1.0 has been applied.

In mysql server do a SHOW TABLES; in testbd database:
```
   +-----------------------+
   | Tables_in_testdb      |
   +-----------------------+
   | DATABASECHANGELOG     |
   | DATABASECHANGELOGLOCK |
   | PERSON                |
   +-----------------------+
```
This shows the PERSON table is present and `DESCRIBE PERSON;` will show the fields for the table.

Note the DATABASECHANGELOG DATABASECHANGELOGLOCK tables that are also present.
Do a 'SELECT * FROM DATABASECHANGELOG;'

And you should see the information stored for the 2 changes applied by the change sets.