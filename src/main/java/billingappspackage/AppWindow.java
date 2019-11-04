package billingappspackage;

import billingappspackage.buttons.*;
import billingappspackage.databaseconnector.DatabaseConnector;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AppWindow extends JFrame {
    public AppController appController;
    //products
    public final List productList = new List(); //awt list
    //billings
    public final List billingList = new List(); //awt list
    public final BillingInfoPanel billingInfoPanel = new BillingInfoPanel();
    //client
    public final List clientList = new List(); //awt list
    //data
    //public DataController dataController = new DataController();
    AppWindow(AppController _appController){
        setTitle("BillingApp");
        setSize(new Dimension(900, 600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setResizable(false);
        requestFocus();
        appController = _appController;
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
        showProductList();
        setVisible(true);
    }
    private void showProductList(){
        for(int i=0; i<appController.dataController.productArrayList.size(); i++){
            productList.add(appController.dataController.productArrayList.get(i).getName() + " " + appController.dataController.productArrayList.get(i).getNettoPrice(), i);
        }
    }
}

