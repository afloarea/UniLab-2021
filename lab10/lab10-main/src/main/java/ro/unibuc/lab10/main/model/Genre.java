package ro.unibuc.lab10.main.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Genre {
    @JsonProperty("drama") DRAMA,
    @JsonProperty("comedy") COMEDY,
    @JsonProperty("action") ACTION
}
