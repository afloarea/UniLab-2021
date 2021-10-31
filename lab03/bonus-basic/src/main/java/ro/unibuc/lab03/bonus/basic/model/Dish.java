package ro.unibuc.lab03.bonus.basic.model;

public record Dish(Integer id, String dishName, int price) {

    public Dish(String dishName, int price) {
        this(null, dishName, price);
    }

}
