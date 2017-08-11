# ejb-interceptors

Maven project created in Intellij using jdk 1.8.

A very simple ejb interceptor on a demo service.

Create the war file and deploy in wildfly.
Navigate to http://localhost:8080/Web-1.0-SNAPSHOT/interceptor in a browser and should show

"Testing interceptor

Person{id=1, name='Mickey', age=50}" 
Confirms that the service has been called correctly.

View the log file and check that the DemoLogger was Invoked

20:09:49,720 INFO  [com.drd.interceptor.interceptors.DemoLogger] (default task-1) Class: 'class com.drd.interceptor.service.PersonService', entering method: 'getById'
