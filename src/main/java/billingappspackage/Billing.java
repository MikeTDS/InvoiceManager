package billingappspackage;

import java.util.ArrayList;

public class Billing {
    public final String name;
    public final String address;
    public final String NIP;
    public final String products;
    public ArrayList<OrderedProduct> orderedProducts;
    public float totalPriceNetto, totalPriceBrutto;

    public Billing(String _name, String _address, String _NIP, String _products,ArrayList<OrderedProduct> _orderedProducts){
        name=_name;
        address=_address;
        NIP=_NIP;
        products=_products;
        orderedProducts=_orderedProducts;
        setTotalPrices();
    }
    private void setTotalPrices(){
        for(int i=0; i<orderedProducts.size(); i++){
            totalPriceNetto += orderedProducts.get(i).getTotalNettoPrice();
            totalPriceBrutto += orderedProducts.get(i).getTotalBruttoPrice();
        }
    }
}
