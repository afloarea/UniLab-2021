package ro.unibuc.lab02.main.init.services.impl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import ro.unibuc.lab02.main.init.model.Review;
import ro.unibuc.lab02.main.init.services.AveragingScoreService;

import java.util.Collection;

@Lazy
@Service
public class AveragingScoreServiceImpl implements AveragingScoreService {

    public AveragingScoreServiceImpl() {
        System.out.println("Averaging score service constructor");
    }

    @Override
    public double calculateAverageRating(Collection<Review> reviews) {
        return reviews.stream()
                .mapToInt(Review::rating)
                .average()
                .orElse(0D);
    }
}
