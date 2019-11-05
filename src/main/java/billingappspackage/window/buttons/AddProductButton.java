package billingappspackage.window.buttons;

import billingappspackage.AppController;
import billingappspackage.window.AppWindow;
import billingappspackage.OrderedProduct;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductButton extends JButton implements ActionListener {
    private final AppController appController;
    public AddProductButton(AppWindow aw){
        setText("Add Product");
        addActionListener(this);
        appController=aw.appController;
    }
    public void actionPerformed(ActionEvent e){
        appController.dataController.addProduct();
    }
}
