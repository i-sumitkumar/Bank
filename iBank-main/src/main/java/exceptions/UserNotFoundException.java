package exceptions;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("User does not exist.");
    }

    public UserNotFoundException(String msg) {
        super(msg);
    }

}
