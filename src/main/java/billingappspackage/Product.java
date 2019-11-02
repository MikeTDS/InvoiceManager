package billingappspackage;

public class Product {
    private final String name;
    private final float nettoPrice;
    private final float bruttoPrice;
    private final int nettoZl;
    private final int nettoGr;
    private final int bruttoZl;
    private final int bruttoGr;
    public Product(String _name, float _nettoPrice){
        name=_name;
        nettoPrice=_nettoPrice;
        bruttoPrice=_nettoPrice*(1.23f);
        nettoZl=(int)nettoPrice;
        nettoGr=(Math.round((nettoPrice-nettoZl)*100));
        bruttoZl=(int)bruttoPrice;
        bruttoGr=(Math.round((bruttoPrice-bruttoZl)*100));
    }
    public String getName(){ return name; }
    public float getNettoPrice() { return nettoPrice; }
    public float getBruttoPrice() { return bruttoPrice; }
    public int getBruttoGr() { return bruttoGr; }
    public int getBruttoZl() { return bruttoZl; }
    public int getNettoZl(){return nettoZl;}
    public int getNettoGr(){return nettoGr;}
}
