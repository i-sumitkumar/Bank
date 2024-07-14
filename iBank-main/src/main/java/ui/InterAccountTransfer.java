/*
 * Created by JFormDesigner on Wed Jul 03 15:50:38 EDT 2024
 */

package ui;

import model.AccountType;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Sumt  Kumar
 */
public class InterAccountTransfer extends AbstractMenuPanel {
    public InterAccountTransfer(MenuPanel menuPanel) {
        super(menuPanel);
        initComponents();
    }

    private void savingToChequing(ActionEvent e) {
        InterAccountAmount interAccountAmount=new InterAccountAmount(getMenuPanel(),AccountType.SAVINGS);
        refreshPanel(interAccountAmount);
    }

    private void chequingToSaving(ActionEvent e) {
        InterAccountAmount interAccountAmount=new InterAccountAmount(getMenuPanel(), AccountType.CHECKING);
        refreshPanel(interAccountAmount);
    }
    protected void returnMenu(ActionEvent e) {
        super.returnMenu(e);
    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Sumit kumar
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(
        new javax.swing.border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn"
        ,javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM
        ,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12)
        ,java.awt.Color.red), getBorder())); addPropertyChangeListener(
        new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
        ){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException()
        ;}});

        //---- label1 ----
        label1.setText("Transfer Money");

        //---- button1 ----
        button1.setText("Saving to Chequing");
        button1.addActionListener(e -> savingToChequing(e));

        //---- button2 ----
        button2.setText("Chequing to Saving");
        button2.addActionListener(e -> chequingToSaving(e));

        //---- button3 ----
        button3.setText("Return");
        button3.addActionListener(e -> returnMenu(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap(148, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addComponent(button2)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(button1)
                                    .addComponent(label1)))
                            .addGap(174, 174, 174))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(button3)
                            .addGap(71, 71, 71))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(label1)
                    .addGap(40, 40, 40)
                    .addComponent(button1)
                    .addGap(31, 31, 31)
                    .addComponent(button2)
                    .addGap(38, 38, 38)
                    .addComponent(button3)
                    .addContainerGap(51, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Sumit kumar
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
