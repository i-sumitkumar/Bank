import api.BankServerApiDemoImpl;
import apiclient.BankServerApiClient;
import apiclient.BankServerApiClientLocalImpl;
import model.ATM;
import service.ATMService;
import service.ATMServiceImpl;
import service.UserService;
import service.UserServiceImpl;
import ui.ATMFrame;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            BankServerApiClient bankServerClient = new BankServerApiClientLocalImpl(new BankServerApiDemoImpl());
            UserService userService = new UserServiceImpl(bankServerClient);
            ATMService atmService = new ATMServiceImpl(bankServerClient);

            ATM atm = getATMInstance();
            atmService.logATMStart(atm.getId(), atm);

            ATMFrame atmFrame = new ATMFrame(atm, userService, atmService);
            atmFrame.setVisible(true);
        });
    }

    /**
     * This method fetches information from the ATM hardware, such as its serial number (id), cash inventory and
     * different thresholds, and creates an ATM object based on that information.
     * <p>
     * Note: For demo purposes, the values are hardcoded in this method.
     *
     * @return ATM object using the hardware information of this machine
     */
    private static ATM getATMInstance() {
        Map<Integer, Integer> cashInventory = new HashMap<>();
        cashInventory.put(100, 10);
        cashInventory.put(50, 20);
        cashInventory.put(20, 50);
        cashInventory.put(10, 100);
        return new ATM(1, cashInventory, 100, 90, 10);
    }
}