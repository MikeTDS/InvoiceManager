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
    public BillingInfoPanel billingInfoPanel;
    public ArrayList<Billing> billingArrayList;
    CreateBillingButton(AppWindow aw){
        setText("New Billing");
        billingArrayList=aw.billingArrayList;
        billingInfoPanel=aw.billingInfoPanel;
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        String name = billingInfoPanel.tfName.getText();
        String address = billingInfoPanel.tfAddress.getText();
        String NIP = billingInfoPanel.tfNIP.getText();
        String order = billingInfoPanel.taProducts.getText();
        try{
            Billing billing = new Billing(name, address, NIP);
            billingArrayList.add(billing);
            FileWriter writer = new FileWriter("C:\\Users\\m_ils\\IdeaProjects\\BillingApp\\billings\\" + Integer.toString(billingArrayList.indexOf(billing)+1) + name + ".txt" );
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
            bw.write("Order: \n");
            bw.write(order);
            bw.close();
            JOptionPane.showMessageDialog(this, "Created new billing.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Could not create billing.");
        }

    }
}

