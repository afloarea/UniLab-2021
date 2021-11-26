package ro.unibuc.lab07.main.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Genre {
    @JsonProperty("drama") DRAMA,
    @JsonProperty("comedy") COMEDY,
    @JsonProperty("historical") HISTORICAL
}
