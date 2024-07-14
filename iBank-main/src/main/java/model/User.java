package model;

public abstract class User {
    protected long id;
    protected String name;
    protected int pin;

    public User(long id, String name, int pin) {
        this.id = id;
        this.name = name;
        this.pin = pin;
    }

    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }


    // Getters & Setters

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPin() {
        return pin;
    }
}
