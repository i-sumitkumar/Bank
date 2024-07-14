/*
 * Created by JFormDesigner on Sat Jun 29 19:17:17 EDT 2024
 */

package ui;

import model.Account;
import model.AccountType;
import model.Customer;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

import static model.AccountType.CHECKING;

/**
 * @author jdiaz
 */
public class WithDrawResult extends AbstractMenuPanel {

    public WithDrawResult(MenuPanel menuPanel, AccountType accountType) {
        super(menuPanel);
        initComponents();

        Customer customer = menuPanel.getCustomer();
        double balanceValue = accountType.equals(CHECKING) ? customer.getChecking().getBalance() :
                customer.getSavings().getBalance();

        this.balance.setText(String.valueOf(balanceValue));
    }

    protected void returnMenu(ActionEvent e) {
        super.returnMenu(e);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jorge Diaz
        label1 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();
        balance = new JLabel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
        javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax
        . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
        .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans.
        PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .
        equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- label1 ----
        label1.setText("Withdrawal was done:");

        //---- label2 ----
        label2.setText("Current Balance is: ");

        //---- button1 ----
        button1.setText("Return to Menu");
        button1.addActionListener(e -> returnMenu(e));

        //---- balance ----
        balance.setText("0.0");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(label2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(balance, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(73, 73, 73)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addGap(35, 35, 35)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addComponent(balance, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                    .addComponent(button1)
                    .addGap(56, 56, 56))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Jorge Diaz
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    private JLabel balance;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
