package exceptions;

public class LoginAttemptLimitException extends Exception{
    public LoginAttemptLimitException() {
        super("Maximum number of login attempts exceeded, please contact the bank customer support.");
    }

    public LoginAttemptLimitException(String message) {
        super(message);
    }
}
