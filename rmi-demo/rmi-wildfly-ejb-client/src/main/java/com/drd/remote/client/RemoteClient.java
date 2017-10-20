package com.drd.remote.client;

import com.drd.remote.calc.RemoteCalculator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.Properties;

/**
 * Author: darren 2017-10-20
 */
public class RemoteClient {

    private final Context context;

    public RemoteClient() throws NamingException {
        final Properties jndiProperties = new Properties();
        jndiProperties.setProperty(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
        this.context = new InitialContext(jndiProperties);
    }

    public static void main(String[] args) throws NamingException, RemoteException {
        RemoteClient remoteClient = new RemoteClient();
        RemoteCalculator remoteCalculator = remoteClient.lookupTheatreBookerEJB();
        int result = remoteCalculator.add(1, 2);
        System.out.printf("Result: '%d'\n", result);
    }

    private RemoteCalculator lookupTheatreBookerEJB() throws NamingException {
        return (RemoteCalculator) context.lookup(
                "ejb:/rmi-wildfly-ejb-1.0-SNAPSHOT/RemoteCalculatorEJB!com.drd.remote.calc.RemoteCalculator");
    }
}