package com.drd.jsf.tomcat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class TableBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Person> persons;

    public TableBean() {
        persons = new ArrayList<Person>();
        persons.add(new Person("Mickey", 10));
        persons.add(new Person("Minnie", 8));
        persons.add(new Person("Donald", 9));
    }

    public List<Person> getPersons() {
        return persons;
    }
}
