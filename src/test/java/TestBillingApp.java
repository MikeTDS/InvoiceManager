import billingappspackage.Product;
import org.junit.Test;

import static org.junit.Assert.*;


public class TestBillingApp {
    private final Product testProduct = new Product("produktTestowy", 1);
    @Test
    public void test1() {
        int k = 1;
        int i = 1;
        assertEquals(i, k);
    }
    @Test
    public void test2(){
        Product prod = new Product("produktTestowy", 1);
        assertNotSame(testProduct, prod);
        prod = testProduct;
        assertSame(testProduct, prod);
    }
}
