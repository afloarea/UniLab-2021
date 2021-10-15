package ro.unibuc.lab01.main.beans.model;

import java.util.Objects;

public class Airplane {

    private String type;
    private int weight;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airplane)) return false;
        Airplane airplane = (Airplane) o;
        return weight == airplane.weight && Objects.equals(type, airplane.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, weight);
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                '}';
    }
}
