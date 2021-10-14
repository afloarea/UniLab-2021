package ro.unibuc.lab01.xml.demo.model;

import java.util.Objects;

public class LabReview {

    private Feedback feedback;
    private String teacher;
    private int rating;

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LabReview)) return false;
        LabReview labReview = (LabReview) o;
        return rating == labReview.rating && Objects.equals(feedback, labReview.feedback) && Objects.equals(teacher, labReview.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedback, teacher, rating);
    }

    @Override
    public String toString() {
        return "LabReview{" +
                "feedback=" + feedback +
                ", teacher='" + teacher + '\'' +
                ", rating=" + rating +
                '}';
    }
}
