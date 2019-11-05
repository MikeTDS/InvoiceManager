package billingappspackage.datacontrollers;

import billingappspackage.*;
import billingappspackage.datacontrollers.DatabaseConnector;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataController {
    private final AppController appController;
    public Client chosenClient;
    public final ArrayList<Product> productArrayList;
    public final ArrayList<OrderedProduct> tempProductList;
    public final ArrayList<Billing> billingArrayList;
    public final ArrayList<Client> clientArrayList;
    public final DatabaseConnector dbConnector = new DatabaseConnector("localhost:3306", "root", "admin123");

    public DataController(AppController _appController) {
        appController = _appController;
        productArrayList = new ArrayList<Product>();
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

    private void addProductsToArrayList() {
        productArrayList.add(new Product("Hammer", 5));
        productArrayList.add(new Product("Lock", 2.5f));
        productArrayList.add(new Product("Axe", 13));
        productArrayList.add(new Product("Screwdriver", 3));
        productArrayList.add(new Product("Pickaxe", 15));
    }

    public void addProduct() {
        try {
            int amount=0;
            String name = productArrayList.get(appController.appWindow.productList.getSelectedIndex()).getName();
            float nettoPrice = productArrayList.get(appController.appWindow.productList.getSelectedIndex()).getNettoPrice();
            Float bruttoPrice = productArrayList.get(appController.appWindow.productList.getSelectedIndex()).getBruttoPrice();
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
                tempProductList.add(orderedProduct);
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

    public void addClient() {
        try{
            String name = JOptionPane.showInputDialog(appController.appWindow, "Name: ");
            if(name!=null) {
                String NIP = JOptionPane.showInputDialog(appController.appWindow, "NIP: ");
                if(!checkIfClientExist(NIP)){
                    String address = JOptionPane.showInputDialog(appController.appWindow, "Address: ");
                    Client client = new Client(name, NIP, address);
                    clientArrayList.add(client);
                    appController.appWindow.clientList.add(client.name);
                    //db
                    dbConnector.addClientToDatabase(client);
                }
                else{
                    JOptionPane.showMessageDialog(appController.appWindow, "This client already exists.");
                }
            }
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(appController.appWindow,"Could not add new client.");
        }
    }

    public void chooseClient() {
        int i = appController.appWindow.clientList.getSelectedIndex();
        if(i!=-1){
            Client client = clientArrayList.get(i);
            appController.appWindow.billingInfoPanel.tfName.setText("Name: " + client.name);
            appController.appWindow.billingInfoPanel.tfAddress.setText("Address: " + client.address);
            appController.appWindow.billingInfoPanel.tfNIP.setText("NIP: " + client.NIP);
            chosenClient = client;
        }
        else{
            JOptionPane.showMessageDialog(appController.appWindow, "You need to choose client first.");
        }
    }

    public void createBilling() {
        try{
            Client client = chosenClient;
            if(client!=null){
                String order = appController.appWindow.billingInfoPanel.taProducts.getText();
                Billing billing = new Billing(client.name, client.address, client.NIP, order, tempProductList);
                billingArrayList.add(billing);
                appController.appWindow.billingList.add((billingArrayList.indexOf(billing) + 1) + ". " + billing.name);
                //db
                dbConnector.addBillingToDatabase(billing);
                client.billingArrayList.add(billing);
                FileWriter writer = new FileWriter("C:\\Users\\m_ils\\IdeaProjects\\BillingApp\\billings\\" + Integer.toString(billingArrayList.indexOf(billing)+1) + client.name + ".txt" );
                //FileWriter writer = new FileWriter("C:\\Users\\PC\\IdeaProjects\\FakturyApp\\billings\\" + (appWindow.billingArrayList.indexOf(billing) + 1) + client.name + ".txt" );
                BufferedWriter bw = new BufferedWriter(writer);
                bw.write("Sprzedawca: \n");
                bw.write("Moja Firma: \n");
                bw.write("ul. Wiosenna 17, 12-345 Wroclaw \n");
                bw.write("NIP: 1234567890 \n");
                bw.write("\n");
                bw.write("Nabywca:  \n");
                bw.write(client.name + "\n");
                bw.write(client.address + "\n");
                bw.write("NIP:" + client.NIP + "\n");
                bw.write("\n");
                bw.write("Zamowienie: \n");
                bw.write(order);
                bw.close();
                JOptionPane.showMessageDialog(appController.appWindow, "Created new billing.");
                appController.appWindow.billingInfoPanel.taProducts.setText("");
                tempProductList.clear();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(appController.appWindow, "Could not create billing.");
        }
    }

    public void showBilling() {
        int i = appController.appWindow.billingList.getSelectedIndex();
        if(i==-1)
            JOptionPane.showMessageDialog(appController.appWindow, "You need to choose billing to show.");
        else{
            Billing chosenBilling = billingArrayList.get(i);
            appController.appWindow.billingInfoPanel.tfName.setText("Name: " + chosenBilling.name);
            appController.appWindow.billingInfoPanel.tfAddress.setText("Address: " + chosenBilling.address);
            appController.appWindow.billingInfoPanel.tfNIP.setText("NIP: " + chosenBilling.NIP);
            appController.appWindow.billingInfoPanel.taProducts.setText(chosenBilling.products);
            appController.appWindow.billingInfoPanel.taProducts.append("Netto:" + String.format("%.2f", chosenBilling.totalPriceNetto) + " Brutto:" + String.format("%.2f", chosenBilling.totalPriceBrutto));
        }
    }
    private boolean checkIfClientExist(String nip){
        for(Client client : clientArrayList){
            if(client.NIP.equals(nip))
                return  true;
        }
        return false;
    }
}