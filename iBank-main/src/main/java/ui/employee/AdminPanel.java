/*
 * Created by JFormDesigner on Thu Jul 04 00:00:18 EDT 2024
 */

package ui.employee;

import model.ATM;
import model.Employee;
import service.ATMService;
import service.UserService;
import ui.AbstractPanel;
import ui.LoginPanel;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author amin_
 */
public class AdminPanel extends AbstractPanel {

    private Employee employee;
    private ATM atm;

    private final UserService userService;
    private final ATMService atmService;

    public AdminPanel(Employee employee, ATM atm, UserService userService, ATMService atmService) {
        this.employee = employee;
        this.atm = atm;
        this.userService = userService;
        this.atmService = atmService;
        initComponents();
        setValues();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    public ATM getAtm() {
        return atm;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public UserService getUserService() {
        return userService;
    }

    public ATMService getAtmService() {
        return atmService;
    }

    private void checkStatus(ActionEvent e) {
        CheckStatusDisplay checkStatusDisplay = new CheckStatusDisplay(this);
        refreshPanel(checkStatusDisplay);
    }
    
    private void setValues() {
        employeeName.setText(this.employee.getName());
    }

    private void startRefillCash(ActionEvent e) {
        RefillSelectDenomination refillSelectDenomination = new RefillSelectDenomination(this);
        refreshPanel(refillSelectDenomination);
    }

    private void startRetrieveCash(ActionEvent e) {
        RetrieveSelectDenomination retrieveSelectDenomination = new RetrieveSelectDenomination(this);
        refreshPanel(retrieveSelectDenomination);
    }

    private void logout(ActionEvent e) {
        employee.reset();
        employee = null;
        LoginPanel loginPanel = new LoginPanel(atm, userService, atmService);
        refreshPanel(loginPanel);
    }

    protected void showUp() {
        getParentFrame().setContentPane(this);
        getParentFrame().revalidate();
        getParentFrame().repaint();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Amin Amani
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        employeeName = new JLabel();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
        border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER
        ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font
        . BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener(
        new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r"
        .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );

        //---- label1 ----
        label1.setText("Hello");

        //---- button1 ----
        button1.setText("Check Status");
        button1.addActionListener(e -> checkStatus(e));

        //---- button2 ----
        button2.setText("Refill Cash");
        button2.addActionListener(e -> startRefillCash(e));

        //---- button3 ----
        button3.setText("Retrieve Cash");
        button3.addActionListener(e -> startRetrieveCash(e));

        //---- button4 ----
        button4.setText("Logout");
        button4.addActionListener(e -> logout(e));

        //---- employeeName ----
        employeeName.setText("text");
        employeeName.setHorizontalAlignment(SwingConstants.LEFT);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(179, 179, 179)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(employeeName, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(137, 137, 137)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(button1, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(button2, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(button3, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))))
                    .addContainerGap(175, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 532, Short.MAX_VALUE)
                    .addComponent(button4)
                    .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(employeeName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(button4)
                    .addGap(5, 5, 5)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(287, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Amin Amani
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel employeeName;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
