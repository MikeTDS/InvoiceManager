package billingappspackage;

public class Product {
    private String name;
    private float nettoPrice, bruttoPrice;
    Product(String _name, float _nettoPrice){
        name=_name;
        nettoPrice=_nettoPrice;
        bruttoPrice=_nettoPrice*(1.23f);
    }
    public String getName(){ return name; }
    public float getNettoPrice() { return nettoPrice; }
    public float getBruttoPrice() { return bruttoPrice; }
}
