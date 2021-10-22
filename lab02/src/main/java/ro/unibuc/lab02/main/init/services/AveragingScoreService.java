package ro.unibuc.lab02.main.init.services;

import ro.unibuc.lab02.main.init.model.Review;

import java.util.Collection;

public interface AveragingScoreService {

    double calculateAverageRating(Collection<Review> reviews);

}
