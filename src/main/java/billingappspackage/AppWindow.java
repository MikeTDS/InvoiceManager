package billingappspackage;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AppWindow extends JFrame {
    //products
    public ArrayList<Product> productArrayList = new ArrayList<Product>();
    public List productList = new List(); //awt list
    private AddProductButton addProductButton = new AddProductButton(this);
    //billings
    private List billingList = new List(); //awt list
    private ShowBillingButton showBillingButton = new ShowBillingButton();
    public BillingInfoPanel billingInfoPanel = new BillingInfoPanel();
    public ArrayList<Billing> billingArrayList = new ArrayList<Billing>();
    private CreateBillingButton createBillingButton = new CreateBillingButton(this);
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
        add(productList);
        add(addProductButton);
        add(new Label("Billings List: "));
        add(billingList);
        addProductsToArrayList();
        showProductList();

    }
    private void addProductsToArrayList(){
        productArrayList.add(new Product("Hammer", 5));
        productArrayList.add(new Product("Lock", 2.5f));
        productArrayList.add(new Product("Axe", 13));
        productArrayList.add(new Product("Screwdriver", 3));
        productArrayList.add(new Product("Pickaxe", 15));
    }
    private void showProductList(){
        for(int i=0; i<productArrayList.size(); i++){
            productList.add(productArrayList.get(i).getName() + " " + productArrayList.get(i).getNettoPrice(), i);
        }
    }
}

