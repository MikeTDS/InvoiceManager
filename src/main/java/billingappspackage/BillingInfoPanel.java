package billingappspackage;

import javax.swing.*;
import java.awt.*;

public class BillingInfoPanel extends JPanel {
    TextField tfName = new TextField(30);
    TextField tfAddress = new TextField(50);
    TextField tfNIP = new TextField(11);
    TextArea taProducts = new TextArea();
    BillingInfoPanel(){
        setLayout(new BoxLayout(this, 1));
        setPreferredSize(new Dimension(800,300));
        setBackground(Color.LIGHT_GRAY);
        add(new Label("Name: "));
        add(tfName);
        add(new Label("Address: "));
        add(tfAddress);
        add(new Label("NIP: "));
        add(tfNIP);
        add(new Label("Products: "));
        add(taProducts);

    }
}