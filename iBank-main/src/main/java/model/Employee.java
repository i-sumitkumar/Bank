package model;

public class Employee extends User {

    public Employee(int id, String name, int pin) {
        super(id, name, pin);
    }

    public Employee(Employee employee) {
        super(0, employee.getName(), 0);
    }

    public void reset() {
        this.id = 0;
        this.name = "";
        this.pin = 0;
    }


    // Clone
    @Override
    public Employee clone() {
        return new Employee(this);
    }
}