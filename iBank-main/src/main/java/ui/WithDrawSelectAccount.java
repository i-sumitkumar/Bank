package ui;

import java.awt.event.ActionEvent;

public class WithDrawSelectAccount extends SelectAccountPanel{

    private final Double amount;
    private final WithDrawSelectAmount selectAmountPanel;

    public WithDrawSelectAccount(MenuPanel menuPanel, WithDrawSelectAmount selectAmountPanel) {
        super(menuPanel);
        this.amount = selectAmountPanel.getAmountValue();
        this.selectAmountPanel = selectAmountPanel;
    }

    @Override
    protected String getTitle() {
        return "WithDraw Money";
    }

    @Override
    protected void selectChecking(ActionEvent e) {
        WithDrawSelectDenomination selectDenomination = new WithDrawSelectDenomination(getMenuPanel(), selectAmountPanel,
                getMenuPanel().getCustomer().getChecking(), amount);
        refreshPanel(selectDenomination);
    }

    @Override
    protected void selectSavings(ActionEvent e) {
        WithDrawSelectDenomination selectDenomination = new WithDrawSelectDenomination(getMenuPanel(), selectAmountPanel,
                getMenuPanel().getCustomer().getSavings(), amount);
        refreshPanel(selectDenomination);
    }
}
