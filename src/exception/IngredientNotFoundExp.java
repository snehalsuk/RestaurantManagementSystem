package exception;

public class IngredientNotFoundExp extends RuntimeException{
    public IngredientNotFoundExp(String message){
        super(message);
    }
}
