package billingappspackage;

import java.util.ArrayList;

public class Client {
    public String name, NIP, address;
    public ArrayList<Billing> billingArrayList = new ArrayList<Billing>();
    public Client(String _name, String _NIP, String _address){
        name=_name;
        NIP=_NIP;
        address=_address;
    }
    public void addBilling(Billing billing){
        billingArrayList.add(billing);
    }
}
