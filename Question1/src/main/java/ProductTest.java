import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    // Unit Test 1
    @Test
    void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        // Sample sales data from the assignment
        int[][] testSales = {
                {25, 18, 20},
                {15, 10, 12},
                {18, 15, 20}
        };
        Product product = new Product(testSales);
        // Expected total = 153
        assertEquals(153, product.GetTotalProductsSold());
    }

    // Unit Test 2
    @Test
    void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        int[][] testSales = {
                {25, 18, 20},
                {15, 10, 12},
                {18, 15, 20}
        };
        Product product = new Product(testSales);
        // Expected average = 153 / 9 = 17
        assertEquals(17, product.GetAverageProductSold(), 0.01);
    }
}