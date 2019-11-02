package billingappspackage.databaseconnector;

import billingappspackage.Billing;
import billingappspackage.Client;
import billingappspackage.Product;

import java.util.ArrayList;

public class DatabaseConnector {
    private final String dataBaseURL;
    private final String login;
    private final String password;
    public DatabaseConnector(String _url, String _login, String _password){
        dataBaseURL=_url;
        login=_login;
        password=_password;
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
