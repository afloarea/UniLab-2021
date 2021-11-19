package ro.unibuc.lab06.main.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Genre {
    @JsonProperty("shooter") SHOOTER,
    @JsonProperty("strategy") STRATEGY,
    @JsonProperty("simulation") SIMULATION
}
