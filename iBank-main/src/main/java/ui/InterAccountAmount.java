/*
 * Created by JFormDesigner on Wed Jul 03 15:52:50 EDT 2024
 */

package ui;

import exceptions.InsufficientFundsException;
import exceptions.UserNotFoundException;
import model.AccountType;
import model.Customer;

import javax.swing.*;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;

/**
 * @author Sumt  Kumar
 */
public class InterAccountAmount extends AbstractMenuPanel {
    private final AccountType accountType;
    private Double transferAmount;

    public InterAccountAmount(MenuPanel menuPanel, AccountType accountType) {

        super(menuPanel);
        this.accountType = accountType;
        initComponents();
    }

    protected void returnMenu(ActionEvent e) {
        super.returnMenu(e);
    }

    private void transferMoney(ActionEvent e) {
        String amountStr = textField1.getText().trim();
       try{
           double amount = Double.parseDouble(amountStr);
           if (this.accountType==AccountType.SAVINGS){
               Customer customer=getMenuPanel().getUserService().transferTo(getMenuPanel().getCustomer().getAccountByType(AccountType.SAVINGS).getAccountNumber(),
                       getMenuPanel().getCustomer().getAccountByType(AccountType.CHECKING).getAccountNumber(),amount);
               getMenuPanel().setCustomer(customer);
           }
           else {
               Customer customer=getMenuPanel().getUserService().transferTo(getMenuPanel().getCustomer().getAccountByType(AccountType.CHECKING).getAccountNumber(),
                       getMenuPanel().getCustomer().getAccountByType(AccountType.SAVINGS).getAccountNumber(),amount);
               getMenuPanel().setCustomer(customer);
           }
           InterAccountResult interAccountResult=new InterAccountResult(getMenuPanel());
           refreshPanel(interAccountResult);
       } catch (UserNotFoundException | InsufficientFundsException ex) {
           System.out.println("Error");
       }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Sumit kumar
        label1 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        textField1 = new JTextField();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing.
        border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing. border. TitledBorder. CENTER
        , javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dialo\u0067" ,java .awt .Font
        .BOLD ,12 ), java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("borde\u0072"
        .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- label1 ----
        label1.setText("Transfer Money");

        //---- label2 ----
        label2.setText("Amount:");

        //---- button1 ----
        button1.setText("Send");
        button1.addActionListener(e -> transferMoney(e));

        //---- button2 ----
        button2.setText("Return");
        button2.addActionListener(e -> returnMenu(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(95, 95, 95)
                            .addComponent(button1)
                            .addGap(55, 55, 55)
                            .addComponent(button2))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(label2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 182, GroupLayout.PREFERRED_SIZE)
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(label1)
                                    .addGap(54, 54, 54)))))
                    .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(label1)
                    .addGap(46, 46, 46)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addGap(86, 86, 86))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Sumit kumar
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    private JTextField textField1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
