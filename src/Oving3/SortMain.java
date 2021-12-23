package Oving3;

import static Oving3.QuickCountsort.*;

public class SortMain {

    public static int n = 5000000;
    public static int n2 = 500000;
    public static int highestNumber = 100;

    public static void main(String[] args) {

        int[] t = generateTable(highestNumber, 0);
        System.out.println("Sum of table one: " + sum(t));
        long start = System.nanoTime();
        quicksort(t, 0, n-1);
        long end = System.nanoTime();
        System.out.println("Sum of table after sort: " + sum(t));
        System.out.println("Table 1 " + (test(t)));
        long startSorted = System.nanoTime();
        quicksort(t, 0, n-1);
        long endSorted = System.nanoTime();
        System.out.println("Total runtime with counting sort: " + (end - start)/1000000 + " milliseconds" );
        System.out.println("Total runtime with counting sort on sorted table: " + (endSorted - startSorted)/1000000
                + " milliseconds\n" );

        int[] t2 = generateTable(highestNumber, 0);
        System.out.println("Sum of table two: " + sum(t2));
        long start2 = System.nanoTime();
        quicksortRegular(t2, 0, n-1);
        long end2 = System.nanoTime();
        System.out.println("Sum of table after sort: " + sum(t2));
        System.out.println("Table 2 " + (test(t2)));
        long start2Sorted = System.nanoTime();
        quicksortRegular(t2, 0, n-1);
        long end2Sorted = System.nanoTime();
        System.out.println("Total runtime without counting sort: " + (end2 - start2)/1000000
                + " milliseconds" );
        System.out.println("Total runtime without counting sort on sorted table: " + (end2Sorted - start2Sorted)/1000000
                + " milliseconds" );
        System.out.println("\nTable 1 " + (test(t)));
        System.out.println("Table 2 " + (test(t2)) + "\n");

        int[] t3 = generate3timesTable(n2);
        System.out.println("Sum of 3 times table: " + sum(t3));
        long start3 = System.nanoTime();
        quicksort(t3, 0, n2-1);
        long end3 = System.nanoTime();
        System.out.println("3 times table 1 " + (test(t3)));
        long start3Sorted = System.nanoTime();
        quicksort(t3, 0, n2-1);
        long end3Sorted = System.nanoTime();
        System.out.println("Sum of 3 times table after sort: " + sum(t3));
        System.out.println("Total runtime with counting sort: " + (end3 - start3)/1000000
                + " milliseconds" );
        System.out.println("Total runtime counting sort on sorted 3 times table: " + (end3Sorted - start3Sorted)/1000000
                + " milliseconds\n" );

        int[] t4 = generate3timesTable(n2);
        System.out.println("Sum of 3 times table two: " + sum(t4));
        long start4 = System.nanoTime();
        quicksortRegular(t4, 0, n2-1);
        long end4 = System.nanoTime();
        System.out.println("3 times table 2 " + (test(t4)));
        long start4Sorted = System.nanoTime();
        quicksortRegular(t4, 0, n2-1);
        long end4Sorted = System.nanoTime();
        System.out.println("Sum of 3 times table two after sort: " + sum(t4));
        System.out.println("Total runtime without counting sort: " + (end4 - start4)/1000000
                + " milliseconds" );
        System.out.println("Total runtime counting sort on sorted 3 times table: " + (end4Sorted - start4Sorted)/1000000
                + " milliseconds" );
        System.out.println("\n3 times table 1 " + (test(t3)));
        System.out.println("3 times table 2 " + (test(t4)));
    }
}
