package ui;

import model.ATM;
import model.Customer;
import service.ATMService;
import service.UserService;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author jdiaz
 */
public class MenuPanel extends AbstractPanel {

    private Customer customer;
    private ATM atm;

    private final UserService userService;
    private final ATMService atmService;

    public MenuPanel(Customer customer, ATM atm, UserService userService, ATMService atmService) {
        this.customer = customer;
        this.atm = atm;
        this.userService = userService;
        this.atmService = atmService;
        initComponents();
        setValues();
    }

    private void setValues() {
        customerName.setText(this.customer.getName());
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

    private void startCheckBalance(ActionEvent e) {
        CheckBalanceSelectAccount balancePanel = new CheckBalanceSelectAccount(this);
        refreshPanel(balancePanel);
    }

    private void logout(ActionEvent e) {
        customer.reset();
        customer = null;
        LoginPanel loginPanel = new LoginPanel(atm, userService, atmService);
        refreshPanel(loginPanel);
    }

    protected void showUp() {
        getParentFrame().setContentPane(this);
        getParentFrame().revalidate();
        getParentFrame().repaint();
    }

    private void startWithDraw(ActionEvent e) {
        WithDrawSelectAmount selectAmount = new WithDrawSelectAmount(this);
        refreshPanel(selectAmount);
    }

    private void startDeposit(ActionEvent e) {
        DepositSelectAccount selectAmount = new DepositSelectAccount(this);
        refreshPanel(selectAmount);
    }

    private void startTransfer(ActionEvent e) {
        InterAccountTransfer interAccountTransfer=new InterAccountTransfer(this);
        refreshPanel(interAccountTransfer);
    }

    private void startSendMoney(ActionEvent e) {
        InteracAmount interacAmount=new InteracAmount(this);
        refreshPanel(interacAmount);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Amin Amani
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        customerName = new JLabel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder(
        0, 0, 0, 0) , "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder
        . BOTTOM, new java .awt .Font ("D\u0069al\u006fg" ,java .awt .Font .BOLD ,12 ), java. awt. Color.
        red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .
        beans .PropertyChangeEvent e) {if ("\u0062or\u0064er" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );

        //---- label1 ----
        label1.setText("Hello");

        //---- button1 ----
        button1.setText("Check Balance");
        button1.addActionListener(e -> startCheckBalance(e));

        //---- button2 ----
        button2.setText("Withdraw");
        button2.addActionListener(e -> startWithDraw(e));

        //---- button3 ----
        button3.setText("Deposit");
        button3.addActionListener(e -> startDeposit(e));

        //---- button4 ----
        button4.setText("Logout");
        button4.addActionListener(e -> logout(e));

        //---- button5 ----
        button5.setText("Transfer");
        button5.addActionListener(e -> {
			startTransfer(e);
			startTransfer(e);
		});

        //---- button6 ----
        button6.setText("Send Money");
        button6.addActionListener(e -> startSendMoney(e));

        //---- customerName ----
        customerName.setText("text");
        customerName.setHorizontalAlignment(SwingConstants.LEFT);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(176, 176, 176)
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(customerName, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(137, 137, 137)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                .addComponent(button1, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(button2, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(button3, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(button5, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addComponent(button6, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))))
                    .addContainerGap(314, Short.MAX_VALUE))
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 532, Short.MAX_VALUE)
                    .addComponent(button4)
                    .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                        .addComponent(customerName, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                    .addGap(6, 6, 6)
                    .addComponent(button4)
                    .addGap(5, 5, 5)
                    .addComponent(button1, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(button2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(button3, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(button5, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(button6, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(146, Short.MAX_VALUE))
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
    private JButton button5;
    private JButton button6;
    private JLabel customerName;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
