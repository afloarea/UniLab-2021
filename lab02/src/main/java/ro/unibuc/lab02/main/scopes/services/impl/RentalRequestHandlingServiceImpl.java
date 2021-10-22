package ro.unibuc.lab02.main.scopes.services.impl;

import org.springframework.stereotype.Service;
import ro.unibuc.lab02.main.scopes.model.RentalRequest;
import ro.unibuc.lab02.main.scopes.services.RentalRequestHanldingService;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RentalRequestHandlingServiceImpl implements RentalRequestHanldingService {

    public RentalRequestHandlingServiceImpl() {
        System.out.println("Created handling service");
    }

    @Override
    public Map<Boolean, List<RentalRequest>> partitionRequests(Collection<RentalRequest> rentalRequests) {
        return rentalRequests.stream()
                .collect(Collectors.partitioningBy(request -> request.sum() > 1000D));
    }
}
