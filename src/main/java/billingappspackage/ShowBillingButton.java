package billingappspackage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowBillingButton extends JButton implements ActionListener {
    AppWindow appWindow;
    ShowBillingButton(AppWindow aw){
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
            appWindow.billingInfoPanel.tfName.setText(chosenBilling.name);
            appWindow.billingInfoPanel.tfAddress.setText(chosenBilling.address);
            appWindow.billingInfoPanel.tfNIP.setText(chosenBilling.NIP);
            appWindow.billingInfoPanel.taProducts.setText(chosenBilling.products);
        }
    }
}