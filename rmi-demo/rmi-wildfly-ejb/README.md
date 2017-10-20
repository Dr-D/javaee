# wildfly-ejb

This is a simple example of rmi using an ejb and ejb-client.
It uses wildfly as I am most familiar with this application server.

Look at the pom.xml for rmi-wildlfy-ejb project.
In the build section it usd maven-ejb-plugin to create a client jar

/rmi-wildfly-ejb/target/rmi-wildfly-ejb-1.0-SNAPSHOT-client.jar

This is a jar required by your client project to be able to interact with the EJB on the server. This would be something like the rmic creating a stub if you look at the README.md for the rmi-registry module.