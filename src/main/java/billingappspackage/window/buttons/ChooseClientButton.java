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
    }
}
