package exceptions;

public class InsufficientAtmCashException extends Exception {

    public InsufficientAtmCashException() {
        super("Insufficient Cash");
    }

    public InsufficientAtmCashException(String msg) {
        super(msg);
    }
}
