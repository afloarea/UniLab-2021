package ro.unibuc.lab02.main.init.services;

import ro.unibuc.lab02.main.init.model.Review;

import java.util.Collection;
import java.util.List;

public interface QualityProductsReviewService {

    List<Review> filterOutBadReviews(Collection<Review> reviews);

}
