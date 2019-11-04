package billingappspackage;

import billingappspackage.databaseconnector.DatabaseConnector;

import java.util.ArrayList;

public class DataController {
    public  AppController appController;
    public Client chosenClient;
    public final ArrayList<Product> productArrayList;
    public final ArrayList<OrderedProduct> tempProductList;
    public final ArrayList<Billing> billingArrayList;
    public final ArrayList<Client> clientArrayList;
    public final DatabaseConnector dbConnector = new DatabaseConnector("localhost:3306", "root", "admin123");
    DataController(AppController _appController){
        appController=_appController;
        productArrayList= new ArrayList<Product>();
        tempProductList = new ArrayList<OrderedProduct>();
        billingArrayList = new ArrayList<Billing>();
        clientArrayList = new ArrayList<Client>();
        //z baza
        dbConnector.openConnection();
        dbConnector.getProductsFromDatabase(productArrayList);
        dbConnector.getClientsFromDatabase(clientArrayList);
        dbConnector.getBillingsFromDatabase(billingArrayList);
        //bez bazy
        addProductsToArrayList();
    }
    private void addProductsToArrayList(){
        productArrayList.add(new Product("Hammer", 5));
        productArrayList.add(new Product("Lock", 2.5f));
        productArrayList.add(new Product("Axe", 13));
        productArrayList.add(new Product("Screwdriver", 3));
        productArrayList.add(new Product("Pickaxe", 15));
    }
}
