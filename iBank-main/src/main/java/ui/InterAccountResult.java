/*
 * Created by JFormDesigner on Wed Jul 03 16:01:15 EDT 2024
 */

package ui;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Sumt  Kumar
 */
public class InterAccountResult extends AbstractMenuPanel {
    public InterAccountResult(MenuPanel menuPanel) {
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
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border
        .EmptyBorder(0,0,0,0), "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e",javax.swing.border.TitledBorder.CENTER,javax
        .swing.border.TitledBorder.BOTTOM,new java.awt.Font("D\u0069al\u006fg",java.awt.Font.BOLD,
        12),java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans
        .PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e){if("\u0062or\u0064er".equals(e.
        getPropertyName()))throw new RuntimeException();}});

        //---- label1 ----
        label1.setText("Transfer Status");

        //---- label2 ----
        label2.setText("Money has been transferred succesfully, Thank you.");

        //---- button1 ----
        button1.setText("Return");
        button1.addActionListener(e -> returnMenu(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(label2)
                    .addContainerGap(24, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(128, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(label1)
                            .addGap(177, 177, 177))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(button1)
                            .addGap(107, 107, 107))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addComponent(label1)
                    .addGap(51, 51, 51)
                    .addComponent(label2)
                    .addGap(66, 66, 66)
                    .addComponent(button1)
                    .addContainerGap(89, Short.MAX_VALUE))
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
