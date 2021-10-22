package ro.unibuc.lab02.main.aop.services.impl;

import org.springframework.stereotype.Service;
import ro.unibuc.lab02.main.aop.model.Person;
import ro.unibuc.lab02.main.aop.services.DrinkingService;

@Service
public class DrinkingServiceImpl implements DrinkingService {

    @Override
    public boolean canDrink(Person person) {
        return person.age() >= 18;
    }
}
