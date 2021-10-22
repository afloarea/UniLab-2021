package ro.unibuc.lab02.main.init.services.impl;

import org.springframework.stereotype.Service;
import ro.unibuc.lab02.main.init.model.Review;
import ro.unibuc.lab02.main.init.services.QualityProductsReviewService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Collection;
import java.util.List;

@Service
public class QualityProductsReviewServiceImpl implements QualityProductsReviewService {

    public QualityProductsReviewServiceImpl() {
        System.out.println("Good reviews service constructor");
    }

    @Override
    public List<Review> filterOutBadReviews(Collection<Review> reviews) {
        return reviews.stream()
                .filter(review -> review.rating() >= 4)
                .toList();
    }

    @PostConstruct
    public void init() {
        System.out.println("Called init method");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("called cleanup");
    }
}
