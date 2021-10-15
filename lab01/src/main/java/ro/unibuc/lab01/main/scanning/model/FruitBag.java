package ro.unibuc.lab01.main.scanning.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class FruitBag {

    private Fruit fruit;
    private double price;

    @Autowired
    public FruitBag(Fruit fruit, @Value("20") double price) {
        this.fruit = fruit;
        this.price = price;
    }

    public FruitBag(double price) {
        this(new Fruit("apple", "yellow"), price);
    }

    public FruitBag() {
        System.out.println("called no params constructor");
        fruit = new Fruit("apple", "red");
        price = 10;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FruitBag)) return false;
        FruitBag fruitBag = (FruitBag) o;
        return Double.compare(fruitBag.price, price) == 0 && Objects.equals(fruit, fruitBag.fruit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fruit, price);
    }

    @Override
    public String toString() {
        return "FruitBag{" +
                "fruit=" + fruit +
                ", price=" + price +
                '}';
    }
}
