package ro.unibuc.lab01.main.qualifiers.model;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Garage {

    private Car car;
    private boolean full;

    public Garage(@Qualifier("cool") Car car, @Value("true") boolean full) {
        this.car = car;
        this.full = full;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Garage)) return false;
        Garage garage = (Garage) o;
        return full == garage.full && Objects.equals(car, garage.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, full);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "car=" + car +
                ", full=" + full +
                '}';
    }
}
