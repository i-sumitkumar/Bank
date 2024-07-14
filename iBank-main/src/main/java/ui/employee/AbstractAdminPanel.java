package ui.employee;

import ui.AbstractPanel;

import java.awt.event.ActionEvent;

public class AbstractAdminPanel extends AbstractPanel {

    private final AdminPanel adminPanel;

    public AbstractAdminPanel(AdminPanel adminPanel) {
        this.adminPanel = adminPanel;
    }

    protected void returnMenu(ActionEvent e) {
        this.adminPanel.showUp();
    }

    public AdminPanel getAdminPanel() {
        return adminPanel;
    }
}
