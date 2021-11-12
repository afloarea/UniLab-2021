package ro.unibuc.lab05.loto.api.dto;

import java.util.Arrays;
import java.util.Objects;

public record LotoRegistration(String name, int[] combination) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LotoRegistration)) return false;
        LotoRegistration that = (LotoRegistration) o;
        return Objects.equals(name, that.name) && Arrays.equals(combination, that.combination);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(combination);
        return result;
    }

    @Override
    public String toString() {
        return "LotoRegistration{" +
                "name='" + name + '\'' +
                ", combination=" + Arrays.toString(combination) +
                '}';
    }
}
