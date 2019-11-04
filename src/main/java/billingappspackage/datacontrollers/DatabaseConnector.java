package billingappspackage.datacontrollers;

import billingappspackage.Billing;
import billingappspackage.Client;
import billingappspackage.Product;

import java.util.ArrayList;

public class DatabaseConnector {
    public DatabaseConnector(String _url, String _login, String _password){
        openConnection();
    }
    public void openConnection(){}
    public void getProductsFromDatabase(ArrayList<Product> products){}
    public void getClientsFromDatabase(ArrayList<Client> clients){}
    public void getBillingsFromDatabase(ArrayList<Billing> billings){}
    public void addClientToDatabase(Client client){}
    public void addBillingToDatabase(Billing billing){}
    public void performQuery(String query){}
}
