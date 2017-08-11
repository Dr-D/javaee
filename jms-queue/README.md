# jms-queue
A JMS Client that can remotely add messages to a queue.
Together with a message driven bean(MDB) that reads messages from the queue.

1)Start Wildfly using full configuration
In the Wildfly bin folder run

./standalone.sh --server-config=standalone-full.xml

2)Add user to Wildfly, in group guest
(make sure that
In the wildfly bin folder run

./add-user.sh

What type of user do you wish to add?
 a) Management User (mgmt-users.properties)
 b) Application User (application-users.properties)
(a): b

Enter the details of the new user to add.
Using realm 'ApplicationRealm' as discovered from the existing property files.
Username : drd
Password recommendations are listed below. To modify these restrictions edit the add-user.properties configuration file.
 - The password should be different from the username
 - The password should not be one of the following restricted values {root, admin, administrator}
 - The password should contain at least 8 characters, 1 alphabetic character(s), 1 digit(s), 1 non-alphanumeric symbol(s)
Password :
WFLYDM0101: Password should have at least 1 digit.
Are you sure you want to use the password entered yes/no? y
Re-enter Password :
What groups do you want this user to belong to?
(Please enter a comma separated list, or leave blank for none)[  ]: guest
About to add user 'drd' for realm 'ApplicationRealm'
Is this correct yes/no? y
Added user 'drd' to file '/home/darren/Applications/wildfly-9.0.1.Final/standalone/configuration/application-users.properties'
Added user 'drd' to file '/home/darren/Applications/wildfly-9.0.1.Final/domain/configuration/application-users.properties'
Added user 'drd' with groups  to file '/home/darren/Applications/wildfly-9.0.1.Final/standalone/configuration/application-roles.properties'
Added user 'drd' with groups  to file '/home/darren/Applications/wildfly-9.0.1.Final/domain/configuration/application-roles.properties'
Is this new user going to be used for one AS process to connect to another AS process?
e.g. for a slave host controller connecting to the master or for a Remoting connection for server to server EJB calls.
yes/no? n

3)Add our queue to Wildfly
To open wildfly command line, in the Wildfly bin folder run

./jboss-cli.sh
You are disconnected at the moment. Type 'connect' to connect to the server or 'help' for the list of supported commands.
[disconnected /] connect
[standalone@localhost:9990 /] jms-queue add --queue-address=demoQueue --entries=java:/jms/queue/demoQueue,java:jboss/exported/jms/queue/demoQueue

4)Run the JMSClient to add files to the the queue
(Make sure you have got the correct username and password on the client)

5)Create the QueueMDB jar file and put in the Wildfly deployment folder.
(Make sure wildfly is running using the full configuration)

These instructions are what to run in a linux configuration,
for windows use the corresponding .bat files.
