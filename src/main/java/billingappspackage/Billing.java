package billingappspackage;

public class Billing {
    public final String name;
    public final String address;
    public final String NIP;
    public final String products;

    public Billing(String _name, String _address, String _NIP, String _products){
        name=_name;
        address=_address;
        NIP=_NIP;
        products=_products;
    }
}
