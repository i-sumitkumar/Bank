/*
 * Created by JFormDesigner on Sat Jun 29 15:11:43 EDT 2024
 */

package ui;

import model.Account;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author jdiaz
 */
public class CheckBalanceDisplay extends AbstractMenuPanel {
    
    private Account account;

    public CheckBalanceDisplay(MenuPanel menuPanel, Account account) {
        super(menuPanel);
        initComponents();
        this.account = account;
        
        setValues(account);
    }

    private void setValues(Account account) {
        this.accountNumber.setText(String.valueOf(account.getAccountNumber()));
        this.balanceAmount.setText(account.getBalance() + " CAD");
    }

    protected void returnMenu(ActionEvent e) {
        super.returnMenu(e);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Sumit kumar
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        returnMenu = new JButton();
        balanceAmount = new JLabel();
        accountNumber = new JLabel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
        swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border
        . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog"
        ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder
        ( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
        .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException
        ( ); }} );

        //---- label1 ----
        label1.setText("Checking Balance");

        //---- label2 ----
        label2.setText("Account ");

        //---- label3 ----
        label3.setText("Your balance is");
        label3.setFont(label3.getFont().deriveFont(Font.PLAIN, label3.getFont().getSize() + 5f));

        //---- returnMenu ----
        returnMenu.setText("Return to Menu");
        returnMenu.addActionListener(e -> returnMenu(e));

        //---- balanceAmount ----
        balanceAmount.setText("##.### CAD");

        //---- accountNumber ----
        accountNumber.setText("XX-XXXX-XX");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(71, 71, 71)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(balanceAmount, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
                            .addGap(72, 72, 72))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                            .addGap(115, 115, 115))
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(accountNumber, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE))
                        .addComponent(returnMenu, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .addGap(38, 38, 38)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
                        .addComponent(accountNumber, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addComponent(balanceAmount, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                    .addGap(30, 30, 30)
                    .addComponent(returnMenu, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(35, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Sumit kumar
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton returnMenu;
    private JLabel balanceAmount;
    private JLabel accountNumber;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
