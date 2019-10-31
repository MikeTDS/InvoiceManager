package billingappspackage;

public class OrderedProduct extends Product {
    public int amount;
    public float totalNettoPrice, totalBruttoPrice;
    public OrderedProduct(String _name, float _nettoPrice, int _amount){
        super(_name, _nettoPrice);
        amount=_amount;
        totalNettoPrice = _nettoPrice*amount;
        totalBruttoPrice = calculateTotalBruttoPrice();
    }
    public float getTotalBruttoPrice() { return totalBruttoPrice; }
    public float getTotalNettoPrice() { return totalNettoPrice; }
    private float calculateTotalBruttoPrice(){
        int gr=getBruttoGr();
        int zl=getBruttoZl();
        return (((amount*gr)%100f)/100f)+amount*zl+((amount*gr)/100);
    }
}
