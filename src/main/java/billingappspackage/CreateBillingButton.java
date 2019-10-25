package billingappspackage;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CreateBillingButton extends JButton implements ActionListener {
    public AppWindow appWindow;
    CreateBillingButton(AppWindow aw){
        setText("New Billing");
        appWindow=aw;
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        String name = appWindow.billingInfoPanel.tfName.getText();
        String address = appWindow.billingInfoPanel.tfAddress.getText();
        String NIP = appWindow.billingInfoPanel.tfNIP.getText();
        String order = appWindow.billingInfoPanel.taProducts.getText();
        System.out.println(order);
        try{
            Billing billing = new Billing(name, address, NIP, order);
            appWindow.billingArrayList.add(billing);
            FileWriter writer = new FileWriter("C:\\Users\\m_ils\\IdeaProjects\\BillingApp\\billings\\" + Integer.toString(appWindow.billingArrayList.indexOf(billing)+1) + name + ".txt" );
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write("Sprzedawca: \n");
            bw.write("Moja Firma: \n");
            bw.write("ul. Wiosenna 17, 12-345 Wroclaw \n");
            bw.write("NIP: 1234567890 \n");
            bw.write("\n");
            bw.write("Nabywca:  \n");
            bw.write(name + "\n");
            bw.write(address + "\n");
            bw.write("NIP:" + NIP + "\n");
            bw.write("\n");
            bw.write("Zamowienie: \n");
            bw.write(order);
            bw.close();
            addBillingToList(billing);
            JOptionPane.showMessageDialog(appWindow, "Created new billing.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(appWindow, "Could not create billing.");
        }
    }
    private void addBillingToList(Billing billing){
        appWindow.billingList.add(Integer.toString(appWindow.billingArrayList.indexOf(billing)+1) + ". " + billing.name);
    }
}

