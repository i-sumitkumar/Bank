/*
 * Created by JFormDesigner on Wed Jul 03 16:09:55 EDT 2024
 */

package ui;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Sumt  Kumar
 */
public class InteracAmount extends AbstractMenuPanel {
    private Double amountValue;

    public InteracAmount(MenuPanel menuPanel)
    {
        super(menuPanel);
        initComponents();
    }

    private void sendInterac(ActionEvent e) {
        String accountNumber = textField1.getText().trim();
        String amountStr = textField2.getText().trim();
        // Validate inputs (basic example)
        if (accountNumber.isEmpty() || amountStr.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter both account number and amount.",
                    "Missing Information",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            double amount = Double.parseDouble(amountStr);


            InteracAccountSelection interacAccountSelection = new InteracAccountSelection(getMenuPanel(),accountNumber,amount);
            refreshPanel(interacAccountSelection);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Invalid amount entered.",
                    "Invalid Input",
                    JOptionPane.ERROR_MESSAGE);
        }
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
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
        new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion"
        , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
        , new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 )
        , java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );

        //---- label1 ----
        label1.setText("Interac");

        //---- label2 ----
        label2.setText("Account No:");

        //---- label3 ----
        label3.setText("Amount:");

        //---- button1 ----
        button1.setText("Send");
        button1.addActionListener(e -> sendInterac(e));

        //---- button2 ----
        button2.setText("Return");
        button2.addActionListener(e -> returnMenu(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(179, 179, 179)
                            .addComponent(label1))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(label2)
                                .addComponent(label3))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(textField2, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(51, 51, 51)
                            .addComponent(button1)
                            .addGap(62, 62, 62)
                            .addComponent(button2)))
                    .addContainerGap(131, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(label1)
                    .addGap(38, 38, 38)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2)
                        .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(28, 28, 28)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label3)
                        .addComponent(textField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addContainerGap(71, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Sumit kumar
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
