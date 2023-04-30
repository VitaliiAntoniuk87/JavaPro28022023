package hometask13;

public class ShoppingDay {

    public static void main(String[] args) {

        int[] prices = {7, 6, 4, 3, 1};

        System.out.println(calcMaxProfit(prices));
    }

    public static int calcMaxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }
}
