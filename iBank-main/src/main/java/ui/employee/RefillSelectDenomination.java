/*
 * Created by JFormDesigner on Thu Jul 04 00:48:07 EDT 2024
 */

package ui.employee;

import exceptions.ATMCashFullException;
import model.ATM;
import model.NotificationType;

import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.GroupLayout;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 * @author amin_
 */
public class RefillSelectDenomination extends AbstractAdminPanel {

    private static final int FIFTY_BILL = 50;
    private static final int TWENTY_BILL = 20;
    private static final int TEN_BILL = 10;
    private static final int HUNDRED_BILL = 100;

    private final Map<Integer, Integer> denominationMap = new HashMap<>();

    public RefillSelectDenomination(AdminPanel adminPanel) {
        super(adminPanel);
        initComponents();
    }

    private void refillCash(ActionEvent e) {
        try {
            ATM atm = getAdminPanel().getAtm();
            atm.depositCash(denominationMap);
            getAdminPanel().getAtmService().logATMDeposit(atm.getId(), getAdminPanel().getEmployee().getId(),
                    denominationMap);
            NotificationType notificationType = atm.checkCashInventoryWarning();
            if (notificationType != null) getAdminPanel().getAtmService().sendNotification(atm.getId(), notificationType);
            super.returnMenu(e);
        } catch (ATMCashFullException ex) {
            showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    protected void returnMenu(ActionEvent e) {
        super.returnMenu(e);
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Amin Amani
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
        label2 = new JLabel();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
        ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
        .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt
        . Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void
        propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
        ;} } );

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
        button1.addActionListener(e -> refillCash(e));

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

        //---- label2 ----
        label2.setText("Select denomination:");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(button2)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                            .addContainerGap(218, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(label2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(73, 73, 73)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)))
                            .addGap(236, 236, 236))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(button2, GroupLayout.Alignment.TRAILING))
                    .addGap(33, 33, 33))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Amin Amani
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
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
