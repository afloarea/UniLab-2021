package ro.unibuc.lab03.main.model;

import java.util.Objects;

public final class Dish {

    private final Integer id;
    private final String name;
    private final int price;

    public Dish(Integer id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Dish(String name, int price) {
        this(null, name, price);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return price == dish.price && Objects.equals(id, dish.id) && Objects.equals(name, dish.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
