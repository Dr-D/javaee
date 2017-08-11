# database-login
Console login using LoginModule and authenticates against a database.

The JAAS configuration file 'jaas.databaseConfig' is in the root of the project,
can alternatively use -Djava.security.auth.login.config=jaas.databaseConfig as JVM option.

Creates H2 file database 'authenticate' in the root of the project if it not already created.
Sets up the database with three users and authenticates against these users.

Shows usage of 'options' from the JAAS configuration.

Uses slf4j-simple to log output to the console.