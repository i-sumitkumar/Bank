/*
 * Created by JFormDesigner on Sat Jun 29 17:57:07 EDT 2024
 */

package ui;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author jdiaz
 */
public class WithDrawSelectAmount extends AbstractMenuPanel {
    
    private Double amountValue;
    
    public WithDrawSelectAmount(MenuPanel menuPanel) {
        super(menuPanel);
        initComponents();
    }

    public Double getAmountValue() {
        return amountValue;
    }

    protected void returnMenu(ActionEvent e) {
        super.returnMenu(e);
    }

    private void goToSelectAccount(ActionEvent e) {
        this.amountValue = Double.parseDouble(this.amount.getText());
        goToSelectAccount();
    }
    
    private void goToSelectAccount() {
        WithDrawSelectAccount selectAccount = new WithDrawSelectAccount(getMenuPanel(), this);
        refreshPanel(selectAccount);
    }

    private void setTwentyAndSelectAccount(ActionEvent e) {
        amountValue = 20.0;
        goToSelectAccount();
    }

    private void setFortyAndSelectAccount(ActionEvent e) {
        amountValue = 40.0;
        goToSelectAccount();
    }

    private void setFiftyAndSelectAccount(ActionEvent e) {
        amountValue = 50.0;
        goToSelectAccount();
    }

    private void setOneHundredAndSelectAccount(ActionEvent e) {
        amountValue = 100.0;
        goToSelectAccount();
    }

    private void setTwoHundredAndSelectAccount(ActionEvent e) {
        amountValue = 200.0;
        goToSelectAccount();
    }

    private void setThreeHundredAndSelectAccount(ActionEvent e) {
        amountValue = 300.0;
        goToSelectAccount();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jorge Diaz
        label1 = new JLabel();
        twenty = new JButton();
        forty = new JButton();
        fifty = new JButton();
        oneHundred = new JButton();
        twoHundred = new JButton();
        threeHundred = new JButton();
        amount = new JTextField();
        ok = new JButton();
        ok2 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new
        javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax
        . swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java
        .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans.
        PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .
        equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- label1 ----
        label1.setText("Enter or select the amount to withdraw:");

        //---- twenty ----
        twenty.setText("20");
        twenty.addActionListener(e -> setTwentyAndSelectAccount(e));

        //---- forty ----
        forty.setText("40");
        forty.addActionListener(e -> setFortyAndSelectAccount(e));

        //---- fifty ----
        fifty.setText("50");
        fifty.addActionListener(e -> setFiftyAndSelectAccount(e));

        //---- oneHundred ----
        oneHundred.setText("100");
        oneHundred.addActionListener(e -> setOneHundredAndSelectAccount(e));

        //---- twoHundred ----
        twoHundred.setText("200");
        twoHundred.addActionListener(e -> setTwoHundredAndSelectAccount(e));

        //---- threeHundred ----
        threeHundred.setText("300");
        threeHundred.addActionListener(e -> setThreeHundredAndSelectAccount(e));

        //---- ok ----
        ok.setText("OK");
        ok.addActionListener(e -> goToSelectAccount(e));

        //---- ok2 ----
        ok2.setText("Return to Menu");
        ok2.addActionListener(e -> returnMenu(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(amount, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 259, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(twenty)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(forty)
                            .addGap(18, 18, 18)
                            .addComponent(fifty))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(oneHundred)
                                    .addGap(12, 12, 12)
                                    .addComponent(twoHundred))
                                .addComponent(ok2))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(threeHundred)
                                .addComponent(ok))))
                    .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(amount, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(fifty, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(forty, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(twenty, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(oneHundred, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(twoHundred, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
                        .addComponent(threeHundred, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(ok)
                        .addComponent(ok2))
                    .addGap(28, 28, 28))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Jorge Diaz
    private JLabel label1;
    private JButton twenty;
    private JButton forty;
    private JButton fifty;
    private JButton oneHundred;
    private JButton twoHundred;
    private JButton threeHundred;
    private JTextField amount;
    private JButton ok;
    private JButton ok2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
