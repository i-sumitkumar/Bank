/*
 * Created by JFormDesigner on Wed Jul 03 16:14:41 EDT 2024
 */

package ui;

import exceptions.InsufficientFundsException;
import exceptions.UserNotFoundException;
import model.Account;
import model.AccountType;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Sumt  Kumar
 */
public class InteracReConfirmationPage extends AbstractMenuPanel {
    private final double amount;
    private final AccountType accountType;
    private final int targetAccountNumber;
    public InteracReConfirmationPage(MenuPanel menuPanel, String accountNumber, double amount, AccountType accountType) {
        super(menuPanel);
        this.amount = amount;
        this.accountType = accountType;
        this.targetAccountNumber = Integer.parseInt(accountNumber);
        initComponents();
        setValues(accountType, targetAccountNumber, amount);
    }

    private void setValues(AccountType accountType, int targetAccountNumber, double amount) {
        // Get the customer's name
        String customerName = this.getMenuPanel().getCustomer().getName();
        this.Customer.setText(customerName);

        // Set the amount value
        this.amountValue.setText(String.valueOf(amount));

        // Get the target user's name
        String targetUserName = this.getMenuPanel().getUserService().getCustomerNameByAccountNumber(targetAccountNumber);
        this.targetUser.setText(targetUserName);
    }




    private void confirmSend(ActionEvent e) {
        try{
            this.getMenuPanel().setCustomer(this.getMenuPanel().getUserService().transferTo(this.getMenuPanel().getCustomer().getAccountByType(accountType).getAccountNumber(),targetAccountNumber,amount));
        } catch (UserNotFoundException | InsufficientFundsException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        InterAccountResult result=new InterAccountResult(getMenuPanel());
        refreshPanel(result);
    }

    protected void returnMenu(ActionEvent e) {
        super.returnMenu(e);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Sumit kumar
        label1 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        Customer = new JLabel();
        label4 = new JLabel();
        amountValue = new JLabel();
        label6 = new JLabel();
        targetUser = new JLabel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
        border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER
        , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font
        .BOLD ,12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order"
        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- label1 ----
        label1.setText("Interac");

        //---- label2 ----
        label2.setText("Hi");

        //---- button1 ----
        button1.setText("Send");
        button1.addActionListener(e -> confirmSend(e));

        //---- button2 ----
        button2.setText("Cancel");
        button2.addActionListener(e -> returnMenu(e));

        //---- Customer ----
        Customer.setText("customerName");

        //---- label4 ----
        label4.setText("Are you sure you want to send $");

        //---- amountValue ----
        amountValue.setText("*****");

        //---- label6 ----
        label6.setText("to");

        //---- targetUser ----
        targetUser.setText("targetUserName");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(180, 180, 180)
                            .addComponent(label1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(48, 48, 48)
                            .addComponent(button1)
                            .addGap(91, 91, 91)
                            .addComponent(button2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(amountValue, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Customer))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label6)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(targetUser, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))))
                    .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(label1)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(Customer, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label4)
                        .addComponent(amountValue))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(targetUser)
                        .addComponent(label6))
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addContainerGap(133, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Sumit kumar
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    private JLabel Customer;
    private JLabel label4;
    private JLabel amountValue;
    private JLabel label6;
    private JLabel targetUser;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
