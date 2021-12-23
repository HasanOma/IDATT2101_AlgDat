package Oving3;

import static Oving3.SortMain.n;

public class QuickCountsort {

    public static int[] generateTable(int max, int min) {
        int[] t = new int[n];
        for (int i = 0; i < t.length; i++) {
            int newInt = (int) ((Math.random() * (max-min))+min);
            t[i] = newInt;
        }
        return t;
    }

    public static int[] generate3timesTable(int n){
        int[] t = new int[n];
        for (int i = t.length-1; i > 0; i--) {
            t[i] = i*3;
        }
        return t;
    }

    public static String test(int[] t) {
        for (int i = 0; i < t.length - 2; i++) {
            if (t[i] > t[i+1]) {
                return "is not sorted";
            }
        }
        return "is sorted";
    }

    public static int sum(int[] t){
        int sum = 0;
        for (int i = 0; i < t.length; i++){
            sum += t[i];
        }
        return sum;
    }

    public static void countsortInt(int []table, int l, int min, int max){
        int j=min;
        int i=min;
        int []helpTable = new int[l+1];
        for (; i <= max; i++) {
            ++helpTable[table[i]];
        }
        for (i = 0; i <= l; i++) {
            while (helpTable[i]-- > 0){
                table[j++] = i;
            }
        }
    }

    public static void quicksortRegular(int []table, int left, int right){
        if (right - left > 2) {
            int pivot = split(table, left, right);
            quicksortRegular(table, left, pivot - 1);
            quicksortRegular(table, pivot + 1, right);
        }else {
            median3sort(table,left,right);
        }
    }

    public static void quicksort(int []table, int left, int right){
        if (right - left > 2) {
        int pivot = split(table, left, right);

        boolean hasCounted = false;

        int highNum = table[left];
        int lowNum = table[left];
        for (int i = left; i <= pivot-1; i++) {
            if (table[i] > highNum){
                highNum = table[i];
            }
            if (table[i] < lowNum){
                lowNum = table[i];
            }
            if (highNum - lowNum > pivot-left-1){
                break;
            }
            if (i==pivot-1){
                countsortInt(table, highNum, left,pivot-1);
                hasCounted = true;
            }
        }
        if (!hasCounted) {
            quicksort(table, left, pivot - 1);
            hasCounted = false;
        }
        int highNum2 = table[pivot];
        int lowNum2 = table[pivot];
        for (int i = pivot+1; i <= right; i++) {
            if (table[i] > highNum2){
                highNum2 = table[i];
            }
            if (table[i] < lowNum2){
                lowNum2 = table[i];
            }
            if (highNum2 - lowNum2 > right-pivot-1){
                break;
            }
            if (i==right){
                countsortInt(table, highNum2, pivot+1,right);
                hasCounted = true;
            }
        }
        if (!hasCounted) {
            quicksort(table, pivot + 1, right);
        }
        }else {
            median3sort(table,left,right);
        }
    }


    public static int split(int[] table, int left, int right) {
        int iLeft, iRight;
        int m = median3sort(table, left, right);
        int dv = table[m];
        swap(table, m, right - 1);
        for (iLeft = left, iRight = right - 1; ; ) {
            while (table[++iLeft] < dv) ;
            while (table[--iRight] > dv) ;
            if (iLeft >= iRight) break;
            swap(table, iLeft, iRight);
        }
        swap(table, iLeft, right-1);
        return iLeft;
    }

    public static int median3sort(int[] t, int v, int h) {
        int m = (v + h) / 2;
        if (t[v] > t[m]) swap(t,v,m);
        if (t[m] > t[h]) {
            swap(t,m,h);
            if(t[v] > t[m]) swap(t,v,m);
        }
        return m;
    }

    public static void swap(int[] t, int a, int b) {
        int temp = t[a];
        t[a] = t[b];
        t[b] = temp;
    }

}
