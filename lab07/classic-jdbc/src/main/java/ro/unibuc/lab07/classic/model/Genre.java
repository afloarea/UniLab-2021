package ro.unibuc.lab07.classic.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Genre {
    @JsonProperty("drama") DRAMA,
    @JsonProperty("comedy") COMEDY,
    @JsonProperty("historical") HISTORICAL,
    @JsonProperty("kids") KIDS
}
