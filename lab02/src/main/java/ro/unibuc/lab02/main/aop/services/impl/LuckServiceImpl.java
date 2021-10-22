package ro.unibuc.lab02.main.aop.services.impl;

import org.springframework.stereotype.Service;
import ro.unibuc.lab02.main.aop.model.Person;
import ro.unibuc.lab02.main.aop.services.LuckService;

@Service
public class LuckServiceImpl implements LuckService {

    @Override
    public boolean isLucky(Person person) {
        return "Ionuț".equals(person.name()) || Math.random() > 0.5D;
    }
}
