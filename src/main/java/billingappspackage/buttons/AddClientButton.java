package billingappspackage.buttons;
import billingappspackage.AppWindow;
import billingappspackage.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddClientButton extends JButton implements ActionListener {
    private final AppWindow appWindow;
    public AddClientButton(AppWindow aw){
      setText("New Client");
      addActionListener(this);
      appWindow=aw;
    }
    public void actionPerformed(ActionEvent e){
        try{
            String name = JOptionPane.showInputDialog(appWindow, "Name: ");
            if(name!=null) {
                String NIP = JOptionPane.showInputDialog(appWindow, "NIP: ");
                String address = JOptionPane.showInputDialog(appWindow, "Address: ");
                Client client = new Client(name, NIP, address);
                appWindow.clientArrayList.add(client);
                appWindow.clientList.add(client.name);
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(appWindow,"Could not add new client.");
        }
    }
}
