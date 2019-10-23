package billingappspackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppWindow extends JFrame {
    ShowBillingButton showBillingButton = new ShowBillingButton();
    BillingInfoPanel billingInfoPanel = new BillingInfoPanel();
    CreateBillingButton createBillingButton = new CreateBillingButton(billingInfoPanel);
    ProductsList productsList = new ProductsList();
    BillingList billingList = new BillingList();
    AppWindow(){
        setSize(new Dimension(800, 600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
        setResizable(false);
        requestFocus();
        add(createBillingButton);
        add(showBillingButton);
        add(billingInfoPanel);
        add(new Label("Products List: "));
        add(productsList);
        add(new Label("Billings List: "));
        add(billingList);
    }
}

