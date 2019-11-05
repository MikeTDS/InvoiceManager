package billingappspackage.window.buttons;

import billingappspackage.AppController;
import billingappspackage.window.AppWindow;
import billingappspackage.Billing;
import billingappspackage.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateBillingButton extends JButton implements ActionListener {
    private final AppController appController;
    public CreateBillingButton(AppWindow aw){
        setText("New Billing");
        appController=aw.appController;
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        appController.dataController.createBilling();
    }
    private void addBillingToList(Billing billing){
        appController.dataController.billingArrayList.add(billing);
        appController.appWindow.billingList.add((appController.dataController.billingArrayList.indexOf(billing) + 1) + ". " + billing.name);
        //db
        appController.dataController.dbConnector.addBillingToDatabase(billing);
    }
}

