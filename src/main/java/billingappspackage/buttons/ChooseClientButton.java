package billingappspackage.buttons;
import billingappspackage.AppWindow;
import billingappspackage.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseClientButton extends JButton implements ActionListener {
    private final AppWindow appWindow;
    public ChooseClientButton(AppWindow aw){
        setText("Choose Client");
        addActionListener(this);
        appWindow=aw;
    }
    public void actionPerformed(ActionEvent e) {
        int i = appWindow.clientList.getSelectedIndex();
        if(i!=-1){
            Client client = appWindow.clientArrayList.get(i);
            appWindow.billingInfoPanel.tfName.setText("Name: " + client.name);
            appWindow.billingInfoPanel.tfAddress.setText("Address: " + client.address);
            appWindow.billingInfoPanel.tfNIP.setText("NIP: " + client.NIP);
            appWindow.chosenClient = client;
        }
        else{
            JOptionPane.showMessageDialog(appWindow, "You need to choose client first.");
        }
    }
}
