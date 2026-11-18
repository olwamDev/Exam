public interface IProductCalculations {
    double GetVat();
    double GetCommission();
    double GetTotal();
}
public class ProductCalculations implements IProductCalculations {

    private double productPrice;

    public ProductCalculations(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public double GetVat() {
        return productPrice * 0.15;
    }

    @Override
    public double GetCommission() {
        return productPrice * 0.05;
    }

    @Override
    public double GetTotal() {
        return productPrice + GetVat() + GetCommission();
    }

    // Main method to test and run
    public static void main(String[] args) {
        ProductCalculations calc = new ProductCalculations(3500);
        System.out.println("VAT: " + calc.GetVat());
        System.out.println("Commission: " + calc.GetCommission());
        System.out.println("Total: " + calc.GetTotal());
    }
}