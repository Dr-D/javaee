# Remote Method Invocation (RMI)

Allows remote calls from a client to a server.

Compile the server and client classes.
```bash
mvn package
```

The compiled classes will be in these folders
/rmi-demo/rmi-registry/target/classes/com/drd/rmi/server/
/rmi-demo/rmi-registry/target/classes/com/drd/rmi/client/

Create stub. Open a bash shell in the classes directory and use rmic to create stub
```
rmic com.drd.rmi.server.RemoteCalculatorImpl
```

In the server directory there should now be a RemoteCalculatorImpl_Stub.class.

Start the rmi registry in the background
```
rmiregistry &
```

Start the server in your IDE or on command line.

Then start the client which should give an appropriate result.



