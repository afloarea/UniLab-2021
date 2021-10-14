package ro.unibuc.lab01.xml.demo.model;

import java.util.Objects;

public final class Feedback {

    private final String from;
    private final String to;
    private final String text;

    public Feedback(String from, String to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Feedback)) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(from, feedback.from) && Objects.equals(to, feedback.to) && Objects.equals(text, feedback.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, text);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
