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
        try {
            int amount=0;
            String name = appController.dataController.productArrayList.get(appController.appWindow.productList.getSelectedIndex()).getName();
            float nettoPrice = appController.dataController.productArrayList.get(appController.appWindow.productList.getSelectedIndex()).getNettoPrice();
            Float bruttoPrice = appController.dataController.productArrayList.get(appController.appWindow.productList.getSelectedIndex()).getBruttoPrice();
            try{
                 amount = Integer.parseInt(JOptionPane.showInputDialog(appController.appWindow, "Amount of products:"));
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(appController.appWindow, "Wrong amount of products.");
            }
            if(amount>0){
                OrderedProduct orderedProduct = new OrderedProduct(name, nettoPrice, amount);
                Float totalNetto = orderedProduct.getTotalNettoPrice();
                Float totalBrutto = orderedProduct.getTotalBruttoPrice();
                appController.dataController.tempProductList.add(orderedProduct);
                appController.appWindow.billingInfoPanel.taProducts.append(amount +"x " + name + " Netto:" + String.format("%.2f", nettoPrice) + " Brutto:" + String.format("%.2f", bruttoPrice)
                        + " Total(netto): " + String.format("%.2f", totalNetto) + " Total(brutto): " + String.format("%.2f", totalBrutto) + "\n");
            }
            else{
                JOptionPane.showMessageDialog(appController.appWindow, "Amount of products must be more than 0.");
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(appController.appWindow, "You need to choose product first.");
        }
    }
}
