package ro.unibuc.lab02.main.scopes.services;

import ro.unibuc.lab02.main.scopes.model.RentalRequest;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface RentalRequestHanldingService {

    Map<Boolean, List<RentalRequest>> partitionRequests(Collection<RentalRequest> rentalRequests);

}
