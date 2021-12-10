package ro.unibuc.lab09.main.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Genre {
    @JsonProperty("drama") DRAMA,
    @JsonProperty("comedy") COMEDY,
    @JsonProperty("action") ACTION
}
