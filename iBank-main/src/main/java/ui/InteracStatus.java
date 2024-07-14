/*
 * Created by JFormDesigner on Wed Jul 03 16:16:39 EDT 2024
 */

package ui;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Sumt  Kumar
 */
public class InteracStatus extends AbstractMenuPanel {
    public InteracStatus(MenuPanel menuPanel)
    {
        super(menuPanel);
        initComponents();
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

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax.
        swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border
        . TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog"
        ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder
        ( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java
        .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException
        ( ); }} );

        //---- label1 ----
        label1.setText("Interac Status");

        //---- label2 ----
        label2.setText("Hi Sumit, your money has sent to jorge succesfully.");

        //---- button1 ----
        button1.setText("Return");
        button1.addActionListener(e -> returnMenu(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(34, 34, 34)
                    .addComponent(label2)
                    .addContainerGap(48, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(159, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(155, 155, 155))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(button1)
                            .addGap(112, 112, 112))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(label1)
                    .addGap(47, 47, 47)
                    .addComponent(label2)
                    .addGap(74, 74, 74)
                    .addComponent(button1)
                    .addContainerGap(87, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Sumit kumar
    private JLabel label1;
    private JLabel label2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
