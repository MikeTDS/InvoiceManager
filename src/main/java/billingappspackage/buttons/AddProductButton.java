package billingappspackage.buttons;

import billingappspackage.AppWindow;
import billingappspackage.OrderedProduct;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductButton extends JButton implements ActionListener {
    private final AppWindow appWindow;
    public AddProductButton(AppWindow aw){
        setText("Add Product");
        appWindow=aw;
        addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        try {
            int amount=0;
            String name = appWindow.productArrayList.get(appWindow.productList.getSelectedIndex()).getName();
            float nettoPrice = appWindow.productArrayList.get(appWindow.productList.getSelectedIndex()).getNettoPrice();
            Float bruttoPrice = appWindow.productArrayList.get(appWindow.productList.getSelectedIndex()).getBruttoPrice();
            try{
                 amount = Integer.parseInt(JOptionPane.showInputDialog(appWindow, "Amount of products:"));
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(appWindow, "Wrong amount of products.");
            }
            if(amount>0){
                OrderedProduct orderedProduct = new OrderedProduct(name, nettoPrice, amount);
                Float totalNetto = orderedProduct.getTotalNettoPrice();
                Float totalBrutto = orderedProduct.getTotalBruttoPrice();
                appWindow.tempProductList.add(orderedProduct);
                appWindow.billingInfoPanel.taProducts.append(amount +"x " + name + " Netto:" + String.format("%.2f", nettoPrice) + " Brutto:" + String.format("%.2f", bruttoPrice)
                        + " Total(netto): " + String.format("%.2f", totalNetto) + " Total(brutto): " + String.format("%.2f", totalBrutto) + "\n");
            }
            else{
                JOptionPane.showMessageDialog(appWindow, "Amount of products must be more than 0.");
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(appWindow, "You need to choose product first.");
        }
    }
}
