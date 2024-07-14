package exceptions;

public class ATMCashFullException extends Exception {

    public ATMCashFullException() {
        super("Atm Cash Capacity Full");
    }

    public ATMCashFullException(String msg) {
        super(msg);
    }
}
