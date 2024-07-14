package ui;

import java.awt.event.ActionEvent;

public class CheckBalanceSelectAccount extends SelectAccountPanel{

    public CheckBalanceSelectAccount(MenuPanel menuPanel) {
        super(menuPanel);
    }

    @Override
    protected String getTitle() {
        return "Check Balance";
    }

    @Override
    protected void selectChecking(ActionEvent e) {
        CheckBalanceDisplay checkBalanceDisplay = new CheckBalanceDisplay(getMenuPanel(), getMenuPanel().getCustomer().getChecking());
        refreshPanel(checkBalanceDisplay);
    }

    @Override
    protected void selectSavings(ActionEvent e) {
        CheckBalanceDisplay checkBalanceDisplay = new CheckBalanceDisplay(getMenuPanel(), getMenuPanel().getCustomer().getSavings());
        refreshPanel(checkBalanceDisplay);
    }
}
