package billingappspackage.window.buttons;
import billingappspackage.AppController;
import billingappspackage.window.AppWindow;
import billingappspackage.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClientButton extends JButton implements ActionListener {
    private final AppController appController;
    public AddClientButton(AppWindow aw){
      setText("New Client");
      addActionListener(this);
        appController=aw.appController;
    }
    public void actionPerformed(ActionEvent e){
        try{
            String name = JOptionPane.showInputDialog(appController.appWindow, "Name: ");
            if(name!=null) {
                String NIP = JOptionPane.showInputDialog(appController.appWindow, "NIP: ");
                String address = JOptionPane.showInputDialog(appController.appWindow, "Address: ");
                Client client = new Client(name, NIP, address);
                appController.dataController.clientArrayList.add(client);
                appController.appWindow.clientList.add(client.name);
                //db
                appController.dataController.dbConnector.addClientToDatabase(client);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(appController.appWindow,"Could not add new client.");
        }
    }
}
