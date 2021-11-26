package ro.unibuc.lab07.main.model;

import java.util.Objects;

public final class Theatre {

    private String id;
    private String name;
    private String city;

    public Theatre() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Theatre)) return false;
        Theatre theatre = (Theatre) o;
        return Objects.equals(id, theatre.id) && Objects.equals(name, theatre.name) && Objects.equals(city, theatre.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Theatre{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
