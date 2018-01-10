package com.drd.jsf.tomcat;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Hello implements Serializable {

    private static final long serialVersionUID = 1L;

    private Person person;

    public Hello() {
        person = new Person();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
