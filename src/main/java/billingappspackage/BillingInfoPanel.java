package billingappspackage;

import javax.swing.*;
import java.awt.*;

public class BillingInfoPanel extends JPanel {
    public TextArea taProducts = new TextArea();
    public Label tfName = new Label("Name: ");
    public Label tfNIP = new Label("NIP: ");
    public Label tfAddress = new Label("Address: ");
    BillingInfoPanel(){
        setLayout(new BoxLayout(this, 1));
        setPreferredSize(new Dimension(840,300));
        setBackground(Color.LIGHT_GRAY);
        add(tfName);
        add(tfAddress);
        add(tfNIP);
        add(new Label());
        add(new Label("Products: "));
        add(taProducts);
    }
}