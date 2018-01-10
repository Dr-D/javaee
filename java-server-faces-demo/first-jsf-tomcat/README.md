# First JSF demo in Tomcat

This is a first example of Java Server Faces running in a tomcat server.

Maven project created in Eclipse Oxygen.

Deploys in Tomcat 8.5.24. 

## Create .war file
In the root directory i.e. java-server-faces-demo
```
mvn clean package
```
Copy the first-jsf-tomcat-0.0.1-SNAPSHOT.war from the first-jsf-tomcat/target/ directory to the apache webapp directory.

Make sure tomcat is running by accessing the server home page http://locahost:8080 in default set up

## Accessing the JSF pages

The pages are accessed by making up the URL from the war file name and then the page name.
http://localhost:8080/first-jsf-tomcat-0.0.1-SNAPSHOT/hello-world.xhtml

You should be able to enter a name and age in the boxes and the response will show these values

## JSF - xhtml
The xhtml standards needs to be followed e.g. <br/> not <br>.
Uses xmlns convention where a namespace can be specified e.g. xmlns:h="http://java.sun.com/jsf/html"

## JSF Managed Beans
For demo purposes a JSF managed bean is used to show how a session scoped bean can be used.

Note that it uses a constructor where as CDI(Contexts and Dependency Injection) will use a method annotated with @PostConstruct.
It is much more likley that you will you EJB/CDI beans in your project rather than JSF managed beans.

Open a session in a browser and then open a session in a second/different browser make sure you are happy that each is session scoped i.e. one browser session does not interfere with the other.
