package ui;

import model.AccountType;
import model.Customer;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

import static model.AccountType.CHECKING;

/**
 * @author amin_
 */
public class DepositResult extends AbstractMenuPanel {

    public DepositResult(MenuPanel menuPanel, AccountType accountType) {
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
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.
        swing.border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",javax.swing.border
        .TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069alog"
        ,java.awt.Font.BOLD,12),java.awt.Color.red), getBorder
        ())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java
        .beans.PropertyChangeEvent e){if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException
        ();}});

        //---- label1 ----
        label1.setText("Deposit was done:");

        //---- label2 ----
        label2.setText("Current Balance is: ");

        //---- button1 ----
        button1.setText("Return to Menu");
        button1.addActionListener(e -> returnMenu(e));

        //---- balance ----
        balance.setText("text");

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
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(balance, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(121, Short.MAX_VALUE))
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
