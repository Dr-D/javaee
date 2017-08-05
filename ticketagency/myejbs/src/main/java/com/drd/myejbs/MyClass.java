package com.drd.myejbs;

/**
 * Author: darren 2017-08-01
 */
public class MyClass {

    int test;

    public MyClass(int test) {
        this.test = test;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "MyClass{" +
                "test=" + test +
                '}';
    }
}
