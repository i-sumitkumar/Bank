/*
 * Created by JFormDesigner on Sat Jun 29 01:48:54 EDT 2024
 */

package ui;

import model.Customer;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author jdiaz
 */
public abstract class SelectAccountPanel extends AbstractMenuPanel {

    public SelectAccountPanel(MenuPanel menuPanel) {
        super(menuPanel);
        initComponents();
        this.title.setText(getTitle());
    }

    protected abstract void selectChecking(ActionEvent e);

    protected void returnMenu(ActionEvent e) {
        super.returnMenu(e);
    }

    protected abstract void selectSavings(ActionEvent e);

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jorge Diaz
        title = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        returnMenu = new JButton();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder
        ( 0, 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border
        . TitledBorder. BOTTOM, new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt
        . Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void
        propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( )
        ; }} );

        //---- title ----
        title.setText("Check Balance");

        //---- label2 ----
        label2.setText("Select Account:");

        //---- button1 ----
        button1.setText("Checking");
        button1.addActionListener(e -> selectChecking(e));

        //---- button2 ----
        button2.setText("Savings");
        button2.addActionListener(e -> selectSavings(e));

        //---- returnMenu ----
        returnMenu.setText("Return to Menu");
        returnMenu.addActionListener(e -> returnMenu(e));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(121, 121, 121)
                            .addComponent(title, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(returnMenu, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 241, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                        .addComponent(button1, GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)))))
                    .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(title, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addGap(37, 37, 37)
                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
                        .addComponent(button2, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                    .addComponent(returnMenu, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    protected abstract String getTitle();

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Jorge Diaz
    private JLabel title;
    private JLabel label2;
    private JButton button1;
    private JButton button2;
    private JButton returnMenu;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
