package exception;

public class InsufficientMoneyExp extends RuntimeException{


    public InsufficientMoneyExp(String message) {
        super(message);
    }
}
