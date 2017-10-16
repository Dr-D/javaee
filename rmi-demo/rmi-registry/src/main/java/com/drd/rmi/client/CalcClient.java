package com.drd.rmi.client;

import com.drd.rmi.server.RemoteCalculator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * @author darrenp - 2017-10-16.
 */
public class CalcClient {

    public static void main(String[] args) {

        try {
            RemoteCalculator calc = (RemoteCalculator) Naming.lookup("/CalculatorServer");
            System.out.printf("Calc add(1, 2): '%d'", calc.add(1, 2) );
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
