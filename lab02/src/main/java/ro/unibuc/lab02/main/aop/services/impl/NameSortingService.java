package ro.unibuc.lab02.main.aop.services.impl;

import org.springframework.stereotype.Service;
import ro.unibuc.lab02.main.aop.model.Person;
import ro.unibuc.lab02.main.aop.services.PersonSortingService;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class NameSortingService implements PersonSortingService {

    @Override
    public List<Person> sort(Person... people) {
        return Arrays.stream(people)
                .sorted(Comparator.comparing(Person::name))
                .toList();
    }
}
