package billingappspackage.window.buttons;

import billingappspackage.AppController;
import billingappspackage.window.AppWindow;
import billingappspackage.Billing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowBillingButton extends JButton implements ActionListener {
    private final AppController appController;
    public ShowBillingButton(AppWindow aw){
        addActionListener(this);
        setText("Show Billing");
        appController = aw.appController;
    }
    public void actionPerformed(ActionEvent e){
        appController.dataController.showBilling();
    }
}