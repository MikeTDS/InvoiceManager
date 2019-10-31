package billingappspackage;

import billingappspackage.buttons.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AppWindow extends JFrame {
    //products
    public ArrayList<Product> productArrayList = new ArrayList<Product>();
    public List productList = new List(); //awt list
    private AddProductButton addProductButton = new AddProductButton(this);
    //billings
    public List billingList = new List(); //awt list
    private ShowBillingButton showBillingButton = new ShowBillingButton(this);
    public BillingInfoPanel billingInfoPanel = new BillingInfoPanel();
    public ArrayList<Billing> billingArrayList = new ArrayList<Billing>();
    private CreateBillingButton createBillingButton = new CreateBillingButton(this);
    //client
    public Client chosenClient;
    public List clientList = new List(); //awt list
    public ArrayList<Client> clientArrayList = new ArrayList<Client>();
    private AddClientButton addClientButton = new AddClientButton(this);
    private ChooseClientButton chooseClientButton = new ChooseClientButton(this);

    AppWindow(){
        setTitle("BillingApp");
        setSize(new Dimension(850, 500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setVisible(true);
        setResizable(false);
        requestFocus();
        add(createBillingButton);
        add(showBillingButton);
        add(addClientButton);
        add(billingInfoPanel);
        add(new Label("Clients: "));
        add(clientList);
        add(chooseClientButton);
        add(new Label("Products: "));
        add(productList);
        add(addProductButton);
        add(new Label("Billings: "));
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

