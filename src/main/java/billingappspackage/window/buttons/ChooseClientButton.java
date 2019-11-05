package billingappspackage.window.buttons;
import billingappspackage.AppController;
import billingappspackage.window.AppWindow;
import billingappspackage.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseClientButton extends JButton implements ActionListener {
    private final AppController appController;
    public ChooseClientButton(AppWindow aw){
        setText("Choose Client");
        addActionListener(this);
        appController=aw.appController;
    }
    public void actionPerformed(ActionEvent e) {
        appController.dataController.chooseClient();
//        int i = appController.appWindow.clientList.getSelectedIndex();
//        if(i!=-1){
//            Client client = appController.dataController.clientArrayList.get(i);
//            appController.appWindow.billingInfoPanel.tfName.setText("Name: " + client.name);
//            appController.appWindow.billingInfoPanel.tfAddress.setText("Address: " + client.address);
//            appController.appWindow.billingInfoPanel.tfNIP.setText("NIP: " + client.NIP);
//            appController.dataController.chosenClient = client;
//        }
//        else{
//            JOptionPane.showMessageDialog(appController.appWindow, "You need to choose client first.");
//        }
    }
}
