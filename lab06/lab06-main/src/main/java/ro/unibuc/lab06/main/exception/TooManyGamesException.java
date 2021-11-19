package ro.unibuc.lab06.main.exception;

public class TooManyGamesException extends RuntimeException {

    public TooManyGamesException(String publisher) {
        super(String.format("Too many games added by publisher %s in the last 10 minutes", publisher));
    }
}
