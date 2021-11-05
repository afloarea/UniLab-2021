package ro.unibuc.lab04.main.model;

public record Dish(Integer id, String name, int price) {

    public Dish(String name, int price) {
        this(null, name, price);
    }
}
