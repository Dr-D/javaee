package com.drd.interceptor.service;

import com.drd.interceptor.interceptors.DemoLogger;
import com.drd.interceptor.model.Person;

import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dr-d on 22/09/15
 */

@Local
@Stateless
public class PersonService {

    List<Person> people;

    @PostConstruct
    public void initialise() {
        List<Person> people = new ArrayList<>();
        people.add(new Person(1L, "Mickey", 50));
        people.add(new Person(2L, "Donald", 45));
        people.add(new Person(3L, "Minnie", 47));
        this.people = people;
    }

    public List<Person> getPeople() {
        return people;
    }

    @Interceptors(DemoLogger.class)
    public Person getById(Long id) {
        for(Person person : people) {
            if(person.getId().equals(id))
                return person;
        }
        return null;
    }
}
