package ui;

import java.awt.event.ActionEvent;

/**
 * @author amin_
 */
public class DepositSelectAccount extends SelectAccountPanel {

    public DepositSelectAccount(MenuPanel menuPanel) {
        super(menuPanel);
    }

    @Override
    protected String getTitle() {
        return "Deposit Money";
    }

    @Override
    protected void selectChecking(ActionEvent e) {
        DepositSelectDenomination selectDenomination = new DepositSelectDenomination(getMenuPanel(),
                getMenuPanel().getCustomer().getChecking());
        refreshPanel(selectDenomination);
    }

    @Override
    protected void selectSavings(ActionEvent e) {
        DepositSelectDenomination selectDenomination = new DepositSelectDenomination(getMenuPanel(),
                getMenuPanel().getCustomer().getSavings());
        refreshPanel(selectDenomination);
    }
}
