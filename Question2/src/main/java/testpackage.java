import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ProductCalculationsTest {

    // Unit Test 1
    @Test
    void GetVat_WithValidData_ReturnsCorrectValue() {
        double testPrice = 3500;
        ProductCalculations calc = new ProductCalculations(testPrice) {
            @Override
            public double GetVat() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public double GetCommission() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public double GetTotal() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        // Expected VAT = 3500 * 0.15 = 525
        assertEquals(525, calc.GetVat(), 0.01);
    }

    // Unit Test 2
    @Test
    void GetTotal_WithValidData_ReturnsCorrectValue() {
        double testPrice = 3500;
        ProductCalculations calc = new ProductCalculations(testPrice) {
            @Override
            public double GetVat() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public double GetCommission() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }

            @Override
            public double GetTotal() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        };
        // Expected Total = 4200
        assertEquals(4200, calc.GetTotal(), 0.01);
    }
}