package com.drd.rmi.server;

import java.rmi.RemoteException;

/**
 * @author darrenp - 2017-10-16.
 */
public interface RemoteCalculator extends java.rmi.Remote {
    int add(int a, int b) throws RemoteException;
}
