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
//        try{
//            Client client = appController.dataController.chosenClient;
//            if(client!=null){
//                String order = appController.appWindow.billingInfoPanel.taProducts.getText();
//                Billing billing = new Billing(client.name, client.address, client.NIP, order, appController.dataController.tempProductList);
//                addBillingToList(billing);
//                client.billingArrayList.add(billing);
//                FileWriter writer = new FileWriter("C:\\Users\\m_ils\\IdeaProjects\\BillingApp\\billings\\" + Integer.toString(appController.dataController.billingArrayList.indexOf(billing)+1) + client.name + ".txt" );
//                //FileWriter writer = new FileWriter("C:\\Users\\PC\\IdeaProjects\\FakturyApp\\billings\\" + (appWindow.billingArrayList.indexOf(billing) + 1) + client.name + ".txt" );
//                BufferedWriter bw = new BufferedWriter(writer);
//                bw.write("Sprzedawca: \n");
//                bw.write("Moja Firma: \n");
//                bw.write("ul. Wiosenna 17, 12-345 Wroclaw \n");
//                bw.write("NIP: 1234567890 \n");
//                bw.write("\n");
//                bw.write("Nabywca:  \n");
//                bw.write(client.name + "\n");
//                bw.write(client.address + "\n");
//                bw.write("NIP:" + client.NIP + "\n");
//                bw.write("\n");
//                bw.write("Zamowienie: \n");
//                bw.write(order);
//                bw.close();
//                JOptionPane.showMessageDialog(appController.appWindow, "Created new billing.");
//                appController.appWindow.billingInfoPanel.taProducts.setText("");
//                appController.dataController.tempProductList.clear();
//            }
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(appController.appWindow, "Could not create billing.");
//        }
    }
    private void addBillingToList(Billing billing){
        appController.dataController.billingArrayList.add(billing);
        appController.appWindow.billingList.add((appController.dataController.billingArrayList.indexOf(billing) + 1) + ". " + billing.name);
        //db
        appController.dataController.dbConnector.addBillingToDatabase(billing);
    }
}

