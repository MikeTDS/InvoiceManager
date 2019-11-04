package billingappspackage;

import billingappspackage.buttons.*;
import billingappspackage.databaseconnector.DatabaseConnector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AppWindow extends JFrame {
    //products
    public final ArrayList<Product> productArrayList = new ArrayList<Product>();
    public final List productList = new List(); //awt list
    public ArrayList<OrderedProduct> tempProductList = new ArrayList<OrderedProduct>();
    //billings
    public final List billingList = new List(); //awt list
    public final BillingInfoPanel billingInfoPanel = new BillingInfoPanel();
    public final ArrayList<Billing> billingArrayList = new ArrayList<Billing>();
    //client
    public Client chosenClient;
    public final List clientList = new List(); //awt list
    public final ArrayList<Client> clientArrayList = new ArrayList<Client>();
    //database
    public final DatabaseConnector dbConnector = new DatabaseConnector("localhost:3306", "root", "admin123");
    AppWindow(){
        setTitle("BillingApp");
        setSize(new Dimension(900, 600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setResizable(false);
        requestFocus();
        add(new CreateBillingButton(this));
        add(new ShowBillingButton(this));
        add(new AddClientButton(this));
        add(billingInfoPanel);
        add(new Label("Clients: "));
        add(clientList);
        add(new ChooseClientButton(this));
        add(new Label("Products: "));
        add(productList);
        add(new AddProductButton(this));
        add(new Label("Billings: "));
        add(billingList);
        //bez bazy
        addProductsToArrayList();
        showProductList();
        //z baza
        dbConnector.openConnection();
        dbConnector.getProductsFromDatabase(productArrayList);
        dbConnector.getClientsFromDatabase(clientArrayList);
        dbConnector.getBillingsFromDatabase(billingArrayList);
        setVisible(true);
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

