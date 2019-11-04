import billingappspackage.Billing;
import billingappspackage.OrderedProduct;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestBilling {
    private ArrayList<OrderedProduct> testOrderedProducts;
    private Billing testBilling;
    @Before
    public void setBilling(){
        testOrderedProducts = new ArrayList<OrderedProduct>();
        testOrderedProducts.add(new OrderedProduct("A", 2.52f, 5));
        testOrderedProducts.add(new OrderedProduct("B", 3.35f, 5));
        testOrderedProducts.add(new OrderedProduct("C", 4.13f, 5));
        testBilling = new Billing("JanKowalskiSA", "ul. Sezamkowa 12", "123123133", "productsText", testOrderedProducts);
    }
    @Test
    public void testArrayListSize(){
        assertEquals(testBilling.orderedProducts.size(), 3);
    }
    @Test
    public void testTotalPrice(){
        assertEquals(testBilling.totalPriceNetto, 50, 0.0f);
        assertEquals(testBilling.totalPriceBrutto, 1.23f*50, 0.01f);
    }
}
