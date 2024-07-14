package ui;

import exceptions.LoginAttemptLimitException;
import exceptions.UserNotFoundException;
import model.ATM;
import model.Customer;
import model.Employee;
import model.User;
import service.ATMService;
import service.UserService;
import ui.employee.AdminPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * @author jdiaz
 */
public class LoginPanel extends JPanel {
    private final ATM atm;
    private final UserService userService;
    private final ATMService atmService;

    public LoginPanel(ATM atm, UserService userService, ATMService atmService) {
        this.atm = atm;
        this.userService = userService;
        this.atmService = atmService;
        initComponents();
    }

    private void performLogin(ActionEvent e) {
        String userId = userField.getText();
        String pin = new String(pinField.getPassword());

        User user = null;

        try {
            user = userService.getUserByIdAndPin(Long.parseLong(userId), Integer.parseInt(pin));
            if (user == null) throw new UserNotFoundException("Invalid ID or PIN.");
        } catch (UserNotFoundException | LoginAttemptLimitException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID & PIN must be numbers.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        if (user instanceof Customer) {
            MenuPanel menuPanel = new MenuPanel((Customer) user, atm, userService, atmService);
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.setContentPane(menuPanel);
            frame.revalidate();
            frame.repaint();
        } else if (user instanceof Employee) {
            AdminPanel adminPanel = new AdminPanel((Employee) user, atm, userService, atmService);
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.setContentPane(adminPanel);
            frame.revalidate();
            frame.repaint();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jorge Diaz
        label1 = new JLabel();
        layeredPane1 = new JLayeredPane();
        label2 = new JLabel();
        label3 = new JLabel();
        userField = new JTextField();
        pinField = new JPasswordField();
        login = new JButton();

        //======== this ========
//        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax .
//        swing. border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e" , javax. swing .border
//        . TitledBorder. CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dialo\u0067"
//        , java .awt . Font. BOLD ,12 ) ,java . awt. Color .red ) , getBorder
//        () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java
//        . beans. PropertyChangeEvent e) { if( "borde\u0072" .equals ( e. getPropertyName () ) )throw new RuntimeException
//        ( ) ;} } );

        //---- label1 ----
        label1.setText("Authentication");

        //======== layeredPane1 ========
        {

            //---- label2 ----
            label2.setText("User");
            layeredPane1.add(label2, JLayeredPane.DEFAULT_LAYER);
            label2.setBounds(15, 25, 65, 25);

            //---- label3 ----
            label3.setText("PIN");
            layeredPane1.add(label3, JLayeredPane.DEFAULT_LAYER);
            label3.setBounds(20, 60, 25, 20);
            layeredPane1.add(userField, JLayeredPane.DEFAULT_LAYER);
            userField.setBounds(65, 20, 80, 30);
            layeredPane1.add(pinField, JLayeredPane.DEFAULT_LAYER);
            pinField.setBounds(65, 55, 80, 30);

            //---- login ----
            login.setText("OK");
            login.addActionListener(e -> performLogin(e));
            layeredPane1.add(login, JLayeredPane.DEFAULT_LAYER);
            login.setBounds(new Rectangle(new Point(60, 105), login.getPreferredSize()));
        }

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(145, 145, 145)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(85, 85, 85)
                            .addComponent(layeredPane1, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(layeredPane1, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(61, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Jorge Diaz
    private JLabel label1;
    private JLayeredPane layeredPane1;
    private JLabel label2;
    private JLabel label3;
    private JTextField userField;
    private JPasswordField pinField;
    private JButton login;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
