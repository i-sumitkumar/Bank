package ui;

import model.ATM;
import service.ATMService;
import service.UserService;

import javax.swing.*;

public class ATMFrame extends JFrame {
    private final ATM atm;
    private final UserService userService;
    private final ATMService atmService;

    public ATMFrame(ATM atm, UserService userService, ATMService atmService) {
        this.atm = atm;
        this.userService = userService;
        this.atmService = atmService;

        setupUI();
    }

    private void setupUI() {
        setTitle("iBank - ATM");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel loginPanel = new LoginPanel(atm, userService, atmService);
        add(loginPanel);
    }
}