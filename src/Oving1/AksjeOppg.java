package Oving1;

public class AksjeOppg {
    // Price changes for each day
    private static final int[] priceChanges = {-1, 3, -9, 2, 2, -1, 2, -1, -5};

    // Complexity of O(n^2)
    public static String maxProfit(int[] priceChanges) {
        int profit = 0;
        int buyDay = 0;
        int sellDay = 0;
        int maxProfit = 0;
        for (int i = 0; i < priceChanges.length; i++) {
            profit = 0;
            for (int j = i; j < priceChanges.length; j++) {
                profit += priceChanges[j];
                if (profit > maxProfit){
                    maxProfit = profit;
                    buyDay = i;
                    sellDay = j+1;
                }
            }
        }

        return "Day bought: " + buyDay + "  Day sold: " + sellDay + "  Profit: " + maxProfit;
    }

    //
    public static int[] randomArray(int n, int min, int max){
        int[] list = new int[n];
        for (int i = 0; i < list.length; i++) {
            int newInt = (int) ((Math.random() * (max-min))+min);
            list[i] = newInt;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(priceChanges));

        long start = System.nanoTime();
        maxProfit(randomArray(10000, -10,10));
        long end = System.nanoTime();
        long total = (end - start)/1000000;
        System.out.println("Total runtime: " + total + " milliseconds");

        long start2 = System.nanoTime();
        maxProfit(randomArray(100000, -10,10));
        long end2 = System.nanoTime();
        long total2 = (end2 - start2)/1000000;
        System.out.println("Total run2time: " + total2 + " milliseconds");
    }
}
