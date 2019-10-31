package billingappspackage;

public class Product {
    private String name;
    private float nettoPrice, bruttoPrice;
    private int nettoZl, nettoGr, bruttoZl, bruttoGr;
    public Product(String _name, float _nettoPrice){
        name=_name;
        nettoPrice=_nettoPrice;
        bruttoPrice=_nettoPrice*(1.23f);
        bruttoZl=(int)bruttoPrice;
        bruttoGr=(Math.round((bruttoPrice-bruttoZl)*100));
    }
    public String getName(){ return name; }
    public float getNettoPrice() { return nettoPrice; }
    public float getBruttoPrice() { return bruttoPrice; }
    public int getBruttoGr() { return bruttoGr; }
    public int getBruttoZl() { return bruttoZl; }
}
