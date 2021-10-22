package ro.unibuc.lab02.main.init;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.unibuc.lab02.main.init.config.InitDemoConfig;
import ro.unibuc.lab02.main.init.model.Review;
import ro.unibuc.lab02.main.init.services.AveragingScoreService;
import ro.unibuc.lab02.main.init.services.QualityProductsReviewService;

import java.util.Collection;
import java.util.List;

public class InitDemo {
    private static final Collection<Review> REVIEWS = List.of(
            new Review("tv", "excellent", 5),
            new Review("monitor", "meh", 2),
            new Review("toaster", "mediocre", 3)
    );

    public static void main(String[] args) {
        final var context = new AnnotationConfigApplicationContext(InitDemoConfig.class);
        System.out.println("Context created");

        final var qualityService = context.getBean(QualityProductsReviewService.class);
        System.out.println("Good reviews " + qualityService.filterOutBadReviews(REVIEWS));

        final var averagingService = context.getBean(AveragingScoreService.class);
        System.out.println("Average review score " + averagingService.calculateAverageRating(REVIEWS));

        System.out.println("Closing context");
        context.close();
        System.out.println("Closed context");
    }

}
