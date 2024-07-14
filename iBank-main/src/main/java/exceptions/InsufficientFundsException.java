package exceptions;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException() {
        super("Insufficient funds.");
    }

    public InsufficientFundsException(String msg) {
        super(msg);
    }
}
