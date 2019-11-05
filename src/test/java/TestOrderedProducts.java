import billingappspackage.OrderedProduct;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestOrderedProducts {
    OrderedProduct orderedProduct;
    int amountOfProducts=6;
    @Before
    public void setOrderedProducts(){
        orderedProduct = new OrderedProduct("A", 2.78f, amountOfProducts);
    }
    @Test
    public void testTotalNetto(){
        assertEquals(orderedProduct.getNettoPrice()*amountOfProducts, orderedProduct.getTotalNettoPrice(), 0.0f);
    }
    @Test
    public void testTotalBrutto(){
        assertEquals(orderedProduct.getBruttoPrice()*amountOfProducts, orderedProduct.getTotalBruttoPrice(), 0.01f);
    }
}
