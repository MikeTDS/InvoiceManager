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
//        int i = appController.appWindow.billingList.getSelectedIndex();
//        if(i==-1)
//            JOptionPane.showMessageDialog(appController.appWindow, "You need to choose billing to show.");
//        else{
//            Billing chosenBilling = appController.dataController.billingArrayList.get(i);
//            appController.appWindow.billingInfoPanel.tfName.setText("Name: " + chosenBilling.name);
//            appController.appWindow.billingInfoPanel.tfAddress.setText("Address: " + chosenBilling.address);
//            appController.appWindow.billingInfoPanel.tfNIP.setText("NIP: " + chosenBilling.NIP);
//            appController.appWindow.billingInfoPanel.taProducts.setText(chosenBilling.products);
//            appController.appWindow.billingInfoPanel.taProducts.append("Netto:" + String.format("%.2f", chosenBilling.totalPriceNetto) + " Brutto:" + String.format("%.2f", chosenBilling.totalPriceBrutto));
//        }
    }
}