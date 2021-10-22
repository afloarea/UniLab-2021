package ro.unibuc.lab02.main.aop.services;

import ro.unibuc.lab02.main.aop.model.Person;

import java.util.List;

public interface PersonSortingService {

    List<Person> sort(Person... people);

}
