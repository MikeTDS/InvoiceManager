package billingappspackage.buttons;

import billingappspackage.AppWindow;
import billingappspackage.Billing;
import billingappspackage.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateBillingButton extends JButton implements ActionListener {
    private final AppWindow appWindow;
    public CreateBillingButton(AppWindow aw){
        setText("New Billing");
        appWindow=aw;
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        try{
            Client client = appWindow.chosenClient;
            if(client!=null){
                String order = appWindow.billingInfoPanel.taProducts.getText();
                Billing billing = new Billing(client.name, client.address, client.NIP, order, appWindow.tempProductList);
                addBillingToList(billing);
                //FileWriter writer = new FileWriter("C:\\Users\\m_ils\\IdeaProjects\\BillingApp\\billings\\" + Integer.toString(appWindow.billingArrayList.indexOf(billing)+1) + name + ".txt" );
                FileWriter writer = new FileWriter("C:\\Users\\PC\\IdeaProjects\\FakturyApp\\billings\\" + (appWindow.billingArrayList.indexOf(billing) + 1) + client.name + ".txt" );
                BufferedWriter bw = new BufferedWriter(writer);
                bw.write("Sprzedawca: \n");
                bw.write("Moja Firma: \n");
                bw.write("ul. Wiosenna 17, 12-345 Wroclaw \n");
                bw.write("NIP: 1234567890 \n");
                bw.write("\n");
                bw.write("Nabywca:  \n");
                bw.write(client.name + "\n");
                bw.write(client.address + "\n");
                bw.write("NIP:" + client.NIP + "\n");
                bw.write("\n");
                bw.write("Zamowienie: \n");
                bw.write(order);
                bw.close();
                JOptionPane.showMessageDialog(appWindow, "Created new billing.");
                appWindow.billingInfoPanel.taProducts.setText("");
                appWindow.tempProductList.clear();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(appWindow, "Could not create billing.");
        }
    }
    private void addBillingToList(Billing billing){
        appWindow.billingArrayList.add(billing);
        appWindow.billingList.add((appWindow.billingArrayList.indexOf(billing) + 1) + ". " + billing.name);
    }
}

