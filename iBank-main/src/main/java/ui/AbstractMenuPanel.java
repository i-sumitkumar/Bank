package ui;

import java.awt.event.ActionEvent;

public class AbstractMenuPanel extends AbstractPanel{

    private final MenuPanel menuPanel;

    public AbstractMenuPanel(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;
    }

    protected void returnMenu(ActionEvent e) {
        this.menuPanel.showUp();
    }

    public MenuPanel getMenuPanel() {
        return menuPanel;
    }
}
