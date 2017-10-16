package com.drd.rmi.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author darrenp - 2017-10-16.
 */
public class RemoteCalculatorImpl extends UnicastRemoteObject implements RemoteCalculator {

    protected RemoteCalculatorImpl() throws RemoteException {}

    public static void main(String[] args) {
        try {
            RemoteCalculator calculator = new RemoteCalculatorImpl();
            Naming.rebind("CalculatorServer", calculator);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
