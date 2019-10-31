package billingappspackage.buttons;

import billingappspackage.AppWindow;
import billingappspackage.Billing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowBillingButton extends JButton implements ActionListener {
    private final AppWindow appWindow;
    public ShowBillingButton(AppWindow aw){
        addActionListener(this);
        setText("Show Billing");
        appWindow=aw;
    }
    public void actionPerformed(ActionEvent e){
        int i = appWindow.billingList.getSelectedIndex();
        if(i==-1)
            JOptionPane.showMessageDialog(appWindow, "You need to choose billing to show.");
        else{
            Billing chosenBilling = appWindow.billingArrayList.get(i);
            appWindow.billingInfoPanel.tfName.setText("Name: " + chosenBilling.name);
            appWindow.billingInfoPanel.tfAddress.setText("Address: " + chosenBilling.address);
            appWindow.billingInfoPanel.tfNIP.setText("NIP: " + chosenBilling.NIP);
            appWindow.billingInfoPanel.taProducts.setText(chosenBilling.products);
        }
    }
}