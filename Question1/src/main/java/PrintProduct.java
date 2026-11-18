public class PrintProduct {

    // Create a Product object as a field
    private Product product;

    // Constructor that receives the Product object
    public PrintProduct(Product product) {
        this.product = product;
    }

    // Method to print total product sales
    public void PrintTotalProductSales() {
        System.out.println("TOTAL PRODUCT SALES: " + product.GetTotalProductsSold());
    }

    // Method to print average product sales
    public void PrintAverageProductSales() {
        System.out.println("AVERAGE PRODUCT SALES: " + product.GetAverageProductSold());
    }

    // Method to print the most popular product
    public void PrintMostPopularProduct() {
        System.out.println("MOST POPULAR PRODUCT: " + product.GetMostPopularProduct());
    }
}