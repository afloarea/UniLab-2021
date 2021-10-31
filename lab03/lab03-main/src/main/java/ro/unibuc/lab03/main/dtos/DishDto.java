package ro.unibuc.lab03.main.dtos;

import java.util.Objects;

public final class DishDto {

    private final String name;
    private final int price;

    public DishDto(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishDto dishDto = (DishDto) o;
        return price == dishDto.price && Objects.equals(name, dishDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "DishDto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
