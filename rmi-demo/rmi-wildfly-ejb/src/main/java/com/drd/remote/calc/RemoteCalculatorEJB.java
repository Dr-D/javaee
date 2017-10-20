package com.drd.remote.calc;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * @author darrenp - 2017-10-16.
 */
@Stateless
@Remote(RemoteCalculator.class)
public class RemoteCalculatorEJB implements RemoteCalculator {

    public int add(int a, int b) {
        return a + b;
    }
}
