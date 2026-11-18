import java.util.Scanner;

public class ProductSalesReport {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Single-dimensional array
        String[] products = {
            "Cozy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"
        };

        // Two-dimensional array for 3 products and 3 months
        int[][] sales = new int[3][3];

        int totalSales = 0;
        int highestSales = 0;
        int popularProduct = 0;

        // Enter sales for each product
        for (int i = 0; i < products.length; i++) {

            for (int j = 0; j < 3; j++) {

                System.out.print("Enter number of sales for month "
                        + (j + 1) + " for " + products[i] + ": ");

                sales[i][j] = input.nextInt();

                totalSales += sales[i][j];
            }
            System.out.println();
        }

        // Calculate total sales for each product
        int[] productTotals = new int[3];

        for (int i = 0; i < products.length; i++) {

            for (int j = 0; j < 3; j++) {

                productTotals[i] += sales[i][j];
            }

            // Find the most popular product
            if (productTotals[i] > highestSales) {
                highestSales = productTotals[i];
                popularProduct = i;
            }
        }

        // Calculate average sales
        double averageSales = (double) totalSales / 9;

        // Display sales report
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("************************************");

        System.out.println("TOTAL PRODUCT SALES: " + totalSales);

        System.out.printf("AVERAGE PRODUCT SALES: %.0f%n",
                averageSales);

        System.out.println("MOST POPULAR PRODUCT: "
                + products[popularProduct] + " (" + highestSales + ")");

        input.close();
    }
}