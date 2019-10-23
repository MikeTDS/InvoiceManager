package billingappspackage;

public class OrderedProduct extends Product {
    public int amount;
    public float totalNettoPrice, totalBruttoPrice;
    OrderedProduct(String _name, float _nettoPrice, int _amount){
        super(_name, _nettoPrice);
        amount=_amount;
        totalBruttoPrice = ((int)(getBruttoPrice()*amount*100))/100f;
        totalNettoPrice = ((int)(getNettoPrice()*amount*100))/100f;
    }
}
