/*
 * Created by JFormDesigner on Thu Jul 04 00:57:48 EDT 2024
 */

package ui.employee;

import java.awt.event.*;
import java.util.Map;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author amin_
 */
public class CheckStatusDisplay extends AbstractAdminPanel {
    
    public CheckStatusDisplay(AdminPanel adminPanel) {
        super(adminPanel);
        initComponents();
        setValues();
    }

    private void setValues() {
        Map<Integer, Integer> cashInventory = this.getAdminPanel().getAtm().getCashInventory();
        amountTens.setText(String.valueOf(cashInventory.get(10)));
        amountTwenties.setText(String.valueOf(cashInventory.get(20)));
        amountFifties.setText(String.valueOf(cashInventory.get(50)));
        amountHundreds.setText(String.valueOf(cashInventory.get(100)));
    }

    protected void returnMenu(ActionEvent e) {
        super.returnMenu(e);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Amin Amani
        tenIcon = new JLabel();
        amountTens = new JTextField();
        button2 = new JButton();
        twentyIcon = new JLabel();
        amountTwenties = new JTextField();
        fiftyIcon = new JLabel();
        amountFifties = new JTextField();
        hundredIcon = new JLabel();
        amountHundreds = new JTextField();
        label2 = new JLabel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (
        new javax. swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e"
        , javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
        , new java .awt .Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 )
        , java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (
        new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("borde\u0072" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );

        //---- tenIcon ----
        tenIcon.setText("text");
        tenIcon.setIcon(new ImageIcon(getClass().getResource("/10.jpeg")));

        //---- amountTens ----
        amountTens.setEditable(false);
        amountTens.setText("0");

        //---- button2 ----
        button2.setText("Return to Menu");
        button2.addActionListener(e -> returnMenu(e));

        //---- twentyIcon ----
        twentyIcon.setText("text");
        twentyIcon.setIcon(new ImageIcon(getClass().getResource("/20.jpeg")));

        //---- amountTwenties ----
        amountTwenties.setEditable(false);
        amountTwenties.setText("0");

        //---- fiftyIcon ----
        fiftyIcon.setText("text");
        fiftyIcon.setIcon(new ImageIcon(getClass().getResource("/50.jpeg")));

        //---- amountFifties ----
        amountFifties.setEditable(false);
        amountFifties.setText("0");

        //---- hundredIcon ----
        hundredIcon.setText("text");
        hundredIcon.setIcon(new ImageIcon(getClass().getResource("/100.jpeg")));

        //---- amountHundreds ----
        amountHundreds.setEditable(false);
        amountHundreds.setText("0");

        //---- label2 ----
        label2.setText("Check Cash Inventory");

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(button2)
                    .addGap(41, 471, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(twentyIcon, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addComponent(tenIcon, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addComponent(fiftyIcon, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                                .addComponent(hundredIcon, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
                            .addGap(199, 199, 199)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(amountHundreds, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(amountFifties, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(amountTens, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(amountTwenties, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addContainerGap(218, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(amountTens, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(twentyIcon, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(amountTwenties, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(fiftyIcon, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(amountFifties, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(hundredIcon, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(amountHundreds, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGap(89, 89, 89)
                    .addComponent(button2)
                    .addGap(33, 33, 33))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Amin Amani
    private JLabel tenIcon;
    private JTextField amountTens;
    private JButton button2;
    private JLabel twentyIcon;
    private JTextField amountTwenties;
    private JLabel fiftyIcon;
    private JTextField amountFifties;
    private JLabel hundredIcon;
    private JTextField amountHundreds;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
