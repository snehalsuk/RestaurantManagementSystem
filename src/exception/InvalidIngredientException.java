package exception;

public class InvalidIngredientException extends RuntimeException {

    public InvalidIngredientException(String message) {
        super(message);
    }
}
