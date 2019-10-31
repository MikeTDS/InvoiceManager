import billingappspackage.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class TestProducts {
    Product testProduct;
    @Before
    public void setTestProduct(){
        testProduct = new Product("testProduct", 2.68f);
    }
    @Test
    public void testConvertingNetto(){
        int zl = testProduct.getNettoZl();
        int gr = testProduct.getNettoGr();
        assertEquals(zl+(gr/100f), testProduct.getNettoPrice(), 0.0f);
    }
    @Test
    public void testConvertingBrutto(){
        int zl = testProduct.getBruttoZl();
        int gr = testProduct.getBruttoGr();
        assertEquals(zl+(gr/100f), testProduct.getBruttoPrice(), 0.01f);
    }
}
