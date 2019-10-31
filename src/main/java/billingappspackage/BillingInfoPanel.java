package billingappspackage;

import javax.swing.*;
import java.awt.*;

public class BillingInfoPanel extends JPanel {
    public final TextArea taProducts = new TextArea();
    public final Label tfName = new Label("Name: ");
    public final Label tfNIP = new Label("NIP: ");
    public final Label tfAddress = new Label("Address: ");
    BillingInfoPanel(){
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setPreferredSize(new Dimension(880,300));
        setBackground(Color.LIGHT_GRAY);
        add(tfName);
        add(tfAddress);
        add(tfNIP);
        add(new Label());
        add(new Label("Products: "));
        add(taProducts);
    }
}