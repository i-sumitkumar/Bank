/*
 * Created by JFormDesigner on Wed Jul 03 16:11:28 EDT 2024
 */

package ui;

import model.AccountType;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Sumt  Kumar
 */
public class InteracAccountSelection extends SelectAccountPanel  {
    private final double amount;
    private final String accountNumber;
    public InteracAccountSelection(MenuPanel menuPanel, String accountNumber, double amount) {
        super(menuPanel);
        this.accountNumber=accountNumber;
        this.amount=amount;

    }




    @Override
    protected void selectChecking(ActionEvent e) {
        InteracReConfirmationPage interacReConfirmationPage = new InteracReConfirmationPage(getMenuPanel(),accountNumber,amount, AccountType.CHECKING);
        refreshPanel(interacReConfirmationPage);
    }

    @Override
    protected void selectSavings(ActionEvent e) {
        InteracReConfirmationPage interacReConfirmationPage = new InteracReConfirmationPage(getMenuPanel(),accountNumber,amount, AccountType.SAVINGS);
        refreshPanel(interacReConfirmationPage);
    }

    @Override
    protected String getTitle() {
        return "";
    }

    protected void returnMenu(ActionEvent e) {
        super.returnMenu(e);
    }

//    private void initComponents() {
//        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
//        // Generated using JFormDesigner Evaluation license - Sumit kumar
//        label1 = new JLabel();
//        button1 = new JButton();
//        button2 = new JButton();
//        button3 = new JButton();
//        label2 = new JLabel();
//
//        //======== this ========
//        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
//        ( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
//        . TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
//        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
//        propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( )
//        ; }} );
//
//        //---- label1 ----
//        label1.setText("Interac ");
//
//        //---- button1 ----
//        button1.setText("Saving");
//        button1.addActionListener(e -> interacFromSaving(e));
//
//        //---- button2 ----
//        button2.setText("Chequing");
//        button2.addActionListener(e -> interacfromChequing(e));
//
//        //---- button3 ----
//        button3.setText("Return");
//        button3.addActionListener(e -> returnMenu(e));
//
//        //---- label2 ----
//        label2.setText("Select Account from which you want to send money.");
//
//        GroupLayout layout = new GroupLayout(this);
//        setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup()
//                .addGroup(layout.createSequentialGroup()
//                    .addGroup(layout.createParallelGroup()
//                        .addGroup(layout.createSequentialGroup()
//                            .addGap(51, 51, 51)
//                            .addGroup(layout.createParallelGroup()
//                                .addComponent(label2)
//                                .addComponent(button3)))
//                        .addGroup(layout.createSequentialGroup()
//                            .addGap(179, 179, 179)
//                            .addComponent(label1))
//                        .addGroup(layout.createSequentialGroup()
//                            .addGap(76, 76, 76)
//                            .addGroup(layout.createParallelGroup()
//                                .addComponent(button2, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
//                                .addComponent(button1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE))))
//                    .addContainerGap(22, Short.MAX_VALUE))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup()
//                .addGroup(layout.createSequentialGroup()
//                    .addGap(22, 22, 22)
//                    .addComponent(label1)
//                    .addGap(4, 4, 4)
//                    .addComponent(label2)
//                    .addGap(33, 33, 33)
//                    .addComponent(button1)
//                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
//                    .addComponent(button2)
//                    .addGap(36, 36, 36)
//                    .addComponent(button3)
//                    .addContainerGap(57, Short.MAX_VALUE))
//        );
//        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
//    }
//
//    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
//    // Generated using JFormDesigner Evaluation license - Sumit kumar
//    private JLabel label1;
//    private JButton button1;
//    private JButton button2;
//    private JButton button3;
//    private JLabel label2;
//    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
