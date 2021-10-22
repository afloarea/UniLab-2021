package ro.unibuc.lab02.main.scopes.services.impl;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ro.unibuc.lab02.main.scopes.model.RentalRequest;
import ro.unibuc.lab02.main.scopes.services.RentalRequestInspectorService;

@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Service
public class RentalRequestInspectorServiceImpl implements RentalRequestInspectorService {

    public RentalRequestInspectorServiceImpl() {
        System.out.println("Created inspecting service");
    }

    @Override
    public void inspect(RentalRequest rentalRequest) {
        System.out.println(rentalRequest);
    }
}
