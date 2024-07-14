/*
 * Created by JFormDesigner on Sat Jun 29 18:30:20 EDT 2024
 */

package ui;

import exceptions.InsufficientAtmCashException;
import exceptions.InsufficientFundsException;
import exceptions.UserNotFoundException;
import model.ATM;
import model.Account;
import model.Customer;
import model.NotificationType;

import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.GroupLayout;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * @author jdiaz
 */
public class WithDrawSelectDenomination extends AbstractMenuPanel {

    private static final int FIFTY_BILL = 50;
    private static final int TWENTY_BILL = 20;
    private static final int TEN_BILL = 10;
    private static final int HUNDRED_BILL = 100;
    private final Account account;
    private final Double amount;
    private final Map<Integer, Integer> denominationMap = new HashMap<>();
    private final WithDrawSelectAmount selectAmountPanel;

    public WithDrawSelectDenomination(MenuPanel menuPanel, WithDrawSelectAmount selectAmountPanel, Account account, Double amount) {
        super(menuPanel);
        initComponents();
        this.account = account;
        this.amount = amount;
        this.withdrawAmount.setText(String.valueOf(amount));
        this.selectAmountPanel = selectAmountPanel;
    }

    protected void returnMenu(ActionEvent e) {
        super.returnMenu(e);
    }

    private void withDraw(ActionEvent e) {

        try {
            if (denominationValuesAreValid()) {
                ATM atm = getMenuPanel().getAtm();
                Customer customer = getMenuPanel().getUserService()
                                                  .withdraw(this.account.getAccountNumber(), this.amount);
                atm.withdrawCash(denominationMap);
                getMenuPanel().setCustomer(customer);
                getMenuPanel().getAtmService().logATMWithdraw(atm.getId(), customer.getId(), denominationMap);

                NotificationType notificationType = atm.checkCashInventoryWarning();
                if (notificationType != null) getMenuPanel().getAtmService().sendNotification(atm.getId(), notificationType);

                WithDrawResult result = new WithDrawResult(getMenuPanel(), account.getAccountType());
                refreshPanel(result);
            } else {
                showMessageDialog(this, "Incorrect Denomination, amount should be " + amount, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (InsufficientFundsException | UserNotFoundException | InsufficientAtmCashException ex) {
            showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean denominationValuesAreValid() {
        return Double.valueOf(this.totalAmount.getText()).equals(amount);
    }
    
    private void numberTensKeyReleased(KeyEvent e) {
        validateAndUpdateAmount(TEN_BILL, numberTens, amountTens);
        denominationMap.put(TEN_BILL, Integer.valueOf(numberTens.getText()));
    }

    private void numberTwentiesKeyReleased(KeyEvent e) {
        validateAndUpdateAmount(TWENTY_BILL, numberTwenties, amountTwenties);
        denominationMap.put(TWENTY_BILL, Integer.valueOf(numberTwenties.getText()));
    }

    private void numberFiftiesKeyReleased(KeyEvent e) {
        validateAndUpdateAmount(FIFTY_BILL, numberFifties, amountFifties);
        denominationMap.put(FIFTY_BILL, Integer.valueOf(numberFifties.getText()));
    }

    private void numberHundredsKeyReleased(KeyEvent e) {
        validateAndUpdateAmount(HUNDRED_BILL, numberHundreds, amountHundreds);
        denominationMap.put(HUNDRED_BILL, Integer.valueOf(numberHundreds.getText()));
    }

    private void validateAndUpdateAmount(int amountPerBill, JTextField numberBillsField, JTextField amountField) {
        String text = numberBillsField.getText();
        int numberBillsValue = 0;

        try {
            numberBillsValue = text.trim().isEmpty() ? 0 : Integer.parseInt(text);
        } catch (NumberFormatException ex) {
            showMessageDialog(this, "Number of bills should be integer", "Error", JOptionPane.ERROR_MESSAGE);
        }
        int amountFiftiesValue = amountPerBill * numberBillsValue;
        amountField.setText(String.valueOf(amountFiftiesValue));
        recalculateTotal();
    }

    private void recalculateTotal() {
        Double amountTensValue = Double.valueOf(this.amountTens.getText());
        Double amountTwentiesValue = Double.valueOf(this.amountTwenties.getText());
        Double amountFiftiesValue = Double.valueOf(this.amountFifties.getText());
        Double amountHundredsValue = Double.valueOf(this.amountHundreds.getText());

        Double totalAmountValue = amountTensValue + amountTwentiesValue + amountFiftiesValue + amountHundredsValue;

        this.totalAmount.setText(String.valueOf(totalAmountValue));
    }

    private void goBackToSelectAmount(ActionEvent e) {
        refreshPanel(this.selectAmountPanel);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jorge Diaz
        tenIcon = new JLabel();
        numberTens = new JTextField();
        plus10 = new JButton();
        minus10 = new JButton();
        amountTens = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        twentyIcon = new JLabel();
        plus20 = new JButton();
        numberTwenties = new JTextField();
        minus20 = new JButton();
        amountTwenties = new JTextField();
        fiftyIcon = new JLabel();
        plusFifty = new JButton();
        numberFifties = new JTextField();
        minusFifty = new JButton();
        amountFifties = new JTextField();
        hundredIcon = new JLabel();
        plusHundred = new JButton();
        numberHundreds = new JTextField();
        minusHundred = new JButton();
        amountHundreds = new JTextField();
        totalAmount = new JTextField();
        label1 = new JLabel();
        button3 = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        withdrawAmount = new JLabel();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
        javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax
        .swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java
        .awt.Font("D\u0069alog",java.awt.Font.BOLD,12),java.awt
        .Color.red), getBorder())); addPropertyChangeListener(new java.beans.
        PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062order".
        equals(e.getPropertyName()))throw new RuntimeException();}});

        //---- tenIcon ----
        tenIcon.setText("text");
        tenIcon.setIcon(new ImageIcon(getClass().getResource("/10.jpeg")));

        //---- numberTens ----
        numberTens.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                numberTensKeyReleased(e);
            }
        });

        //---- plus10 ----
        plus10.setText("+");

        //---- minus10 ----
        minus10.setText("-");

        //---- amountTens ----
        amountTens.setEditable(false);
        amountTens.setText("0");

        //---- button1 ----
        button1.setText("OK");
        button1.addActionListener(e -> withDraw(e));

        //---- button2 ----
        button2.setText("Return to Menu");
        button2.addActionListener(e -> returnMenu(e));

        //---- twentyIcon ----
        twentyIcon.setText("text");
        twentyIcon.setIcon(new ImageIcon(getClass().getResource("/20.jpeg")));

        //---- plus20 ----
        plus20.setText("+");

        //---- numberTwenties ----
        numberTwenties.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                numberTwentiesKeyReleased(e);
            }
        });

        //---- minus20 ----
        minus20.setText("-");

        //---- amountTwenties ----
        amountTwenties.setEditable(false);
        amountTwenties.setText("0");

        //---- fiftyIcon ----
        fiftyIcon.setText("text");
        fiftyIcon.setIcon(new ImageIcon(getClass().getResource("/50.jpeg")));

        //---- plusFifty ----
        plusFifty.setText("+");

        //---- numberFifties ----
        numberFifties.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                numberFiftiesKeyReleased(e);
            }
        });

        //---- minusFifty ----
        minusFifty.setText("-");

        //---- amountFifties ----
        amountFifties.setEditable(false);
        amountFifties.setText("0");

        //---- hundredIcon ----
        hundredIcon.setText("text");
        hundredIcon.setIcon(new ImageIcon(getClass().getResource("/100.jpeg")));

        //---- plusHundred ----
        plusHundred.setText("+");

        //---- numberHundreds ----
        numberHundreds.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                numberHundredsKeyReleased(e);
            }
        });

        //---- minusHundred ----
        minusHundred.setText("-");

        //---- amountHundreds ----
        amountHundreds.setEditable(false);
        amountHundreds.setText("0");

        //---- totalAmount ----
        totalAmount.setEditable(false);
        totalAmount.setText("0");

        //---- label1 ----
        label1.setText("TOTAL:");

        //---- button3 ----
        button3.setText("Change Amount");
        button3.addActionListener(e -> goBackToSelectAmount(e));

        //---- label2 ----
        label2.setText("Select denomination:");

        //---- label3 ----
        label3.setText("Amount:");

        //---- withdrawAmount ----
        withdrawAmount.setText("text");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(button2)
                    .addGap(46, 46, 46)
                    .addComponent(button3)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                    .addGap(41, 41, 41))
                .addGroup(layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(twentyIcon, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(plus20, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(numberTwenties, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(minus20, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(tenIcon, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(plus10, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(numberTens, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(minus10, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(fiftyIcon, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(plusFifty, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(numberFifties, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(minusFifty, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(hundredIcon, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(plusHundred, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(numberHundreds, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                                    .addGap(6, 6, 6)
                                    .addComponent(minusHundred, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
                            .addGap(69, 69, 69)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(totalAmount, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(amountHundreds, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(amountFifties, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(amountTens, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(amountTwenties, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addContainerGap(88, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(73, 73, 73)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(withdrawAmount, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                            .addGap(75, 75, 75))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                        .addComponent(withdrawAmount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(tenIcon, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addComponent(plus10)
                        .addComponent(numberTens, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(minus10)
                        .addComponent(amountTens, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(twentyIcon, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(plus20)
                                .addComponent(numberTwenties, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(minus20)
                                .addComponent(amountTwenties, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(fiftyIcon, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(plusFifty)
                                .addComponent(numberFifties, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(minusFifty)
                                    .addComponent(amountFifties, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(hundredIcon, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(plusHundred)
                                .addComponent(numberHundreds, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(minusHundred)
                                    .addComponent(amountHundreds, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(totalAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addGap(36, 36, 36)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(button1, GroupLayout.Alignment.TRAILING)
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button2)
                            .addComponent(button3)))
                    .addGap(33, 33, 33))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Jorge Diaz
    private JLabel tenIcon;
    private JTextField numberTens;
    private JButton plus10;
    private JButton minus10;
    private JTextField amountTens;
    private JButton button1;
    private JButton button2;
    private JLabel twentyIcon;
    private JButton plus20;
    private JTextField numberTwenties;
    private JButton minus20;
    private JTextField amountTwenties;
    private JLabel fiftyIcon;
    private JButton plusFifty;
    private JTextField numberFifties;
    private JButton minusFifty;
    private JTextField amountFifties;
    private JLabel hundredIcon;
    private JButton plusHundred;
    private JTextField numberHundreds;
    private JButton minusHundred;
    private JTextField amountHundreds;
    private JTextField totalAmount;
    private JLabel label1;
    private JButton button3;
    private JLabel label2;
    private JLabel label3;
    private JLabel withdrawAmount;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
