package ui;

import javax.swing.*;

public class AbstractPanel extends JPanel {

    private JFrame parent;

    protected JFrame getParentFrame() {

        if (parent == null) {
            parent = (JFrame) SwingUtilities.getWindowAncestor(this);
        }

        return parent;
    }

    protected void refreshPanel(JPanel balancePanel) {
        getParentFrame().setContentPane(balancePanel);
        getParentFrame().revalidate();
        getParentFrame().repaint();
    }
}
