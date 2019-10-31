package billingappspackage;

import java.util.ArrayList;

public class Client {
    public final String name;
    public final String NIP;
    public final String address;
    private final ArrayList<Billing> billingArrayList = new ArrayList<Billing>();
    public Client(String _name, String _NIP, String _address){
        name=_name;
        NIP=_NIP;
        address=_address;
    }
}
