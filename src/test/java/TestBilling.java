import billingappspackage.Billing;
import billingappspackage.OrderedProduct;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestBilling {
    private Billing testBilling;
    @Before
    public void setBilling(){
        ArrayList<OrderedProduct> testOrderedProducts = new ArrayList<OrderedProduct>();
        testOrderedProducts.add(new OrderedProduct("A", 2.52f, 5));
        testOrderedProducts.add(new OrderedProduct("B", 3.35f, 5));
        testOrderedProducts.add(new OrderedProduct("C", 4.13f, 5));
        testBilling = new Billing("JanKowalskiSA", "ul. Sezamkowa 12", "123123133", "productsText", testOrderedProducts);
    }
    @Test
    public void testArrayListSize(){
        assertTrue(testBilling.orderedProducts.size()==3);
    }
    @Test
    public void testTotalPrice(){
        assertEquals(testBilling.totalPriceNetto, 50, 0.0f);
        assertEquals(testBilling.totalPriceBrutto, 1.23f*50, 0.01f);
    }
}
