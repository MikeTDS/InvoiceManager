package billingappspackage;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CreateBillingButton extends JButton implements ActionListener {
    BillingInfoPanel billingInfoPanel;
    CreateBillingButton(BillingInfoPanel bip){
        setText("New Billing");
        billingInfoPanel=bip;
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        try{
            FileWriter writer = new FileWriter("myfile.txt");
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write("xddd");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}

