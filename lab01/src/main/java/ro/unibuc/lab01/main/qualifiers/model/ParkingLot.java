package ro.unibuc.lab01.main.qualifiers.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ParkingLot {
    private Car car;
    private String size;

    public ParkingLot(Car car, @Value("big") String size) {
        this.car = car;
        this.size = size;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingLot)) return false;
        ParkingLot that = (ParkingLot) o;
        return Objects.equals(car, that.car) && Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, size);
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "car=" + car +
                ", size='" + size + '\'' +
                '}';
    }
}
