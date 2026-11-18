public class Product implements IProduct {

    // Single array to store product names
    private String[] productNames = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
    // 2D array: 3 products × 3 months sales
    private int[][] salesData = {
            {25, 18, 20},
            {15, 10, 12},
            {18, 15, 20}
    };

    // Calculate total of all sales
    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int i = 0; i < salesData.length; i++) {
            for (int j = 0; j < salesData[i].length; j++) {
                total = total + salesData[i][j];
            }
        }
        return total;
    }

    // Calculate average sales
    @Override
    public double GetAverageProductSold() {
        int totalSales = GetTotalProductsSold();
        int totalEntries = salesData.length * salesData[0].length;
        return (double) totalSales / totalEntries;
    }

    // Find product with highest total sales
    @Override
    public String GetMostPopularProduct() {
        int highestTotal = 0;
        String popularProduct = "";

        for (int i = 0; i < salesData.length; i++) {
            int productTotal = 0;
            for (int j = 0; j < salesData[i].length; j++) {
                productTotal = productTotal + salesData[i][j];
            }
            if (productTotal > highestTotal) {
                highestTotal = productTotal;
                popularProduct = productNames[i];
            }
        }
        return popularProduct + "(" + highestTotal + ")";
    }
}
