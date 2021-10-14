package ro.unibuc.lab01.xml.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ro.unibuc.lab01.xml.demo.model.Feedback;
import ro.unibuc.lab01.xml.demo.model.LabReview;

import java.text.MessageFormat;

public class App {

    public static void main(String[] args) {

        final ApplicationContext context =
                new ClassPathXmlApplicationContext("/ro/unibuc/lab01/xml/demo/spring-beans.xml");

        final var firstFeedback = context.getBean("lab-feedback", Feedback.class);
        final var secondFeedback = (Feedback) context.getBean("lab-feedback");

        System.out.printf("First feedback: %s%n", firstFeedback);
        System.out.println(MessageFormat.format("Second feedback: {0}", secondFeedback));
        System.out.println("Same feedback? " + (firstFeedback == secondFeedback));

        final var review = context.getBean(LabReview.class);
        System.out.println("Lab review: " + review);
    }

}
