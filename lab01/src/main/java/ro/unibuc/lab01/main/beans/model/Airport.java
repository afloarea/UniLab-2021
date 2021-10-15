package ro.unibuc.lab01.main.beans.model;

import java.util.Objects;

public class Airport {

    private Airplane airplane;
    private String name;

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;
        Airport airport = (Airport) o;
        return Objects.equals(airplane, airport.airplane) && Objects.equals(name, airport.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(airplane, name);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airplane=" + airplane +
                ", name='" + name + '\'' +
                '}';
    }
}
