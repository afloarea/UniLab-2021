package ro.unibuc.lab06.main.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public record ErrorResponse(@JsonInclude(JsonInclude.Include.NON_NULL) String field, String message) {

    public ErrorResponse(String message) {
        this(null, message);
    }
}
