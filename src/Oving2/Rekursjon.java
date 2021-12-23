package Oving2;

public class Rekursjon {

    // 1: 2.1-1
    public static double faculty(double x, int n){
        if (n == 0){
            return 1;
        }
        if (n >= 1){
            return x*faculty(x,n-1);
        }
        return x;
    }

    // 2: 2.2-3
    public static double faculty2(double x, int n){
        if (n == 0){
            return 1;
        } else if(n%2!=0){
            return x*faculty2(x*x,(n-1)/2);
        } else {
            return faculty2(x*x,n/2);
        }
    }

    // 3: Math.pow
    public static double mathPow(double x, double n){
        return Math.pow(x,n);
    }

    public static void main(String[] args) {
        double x = 1.001;
        int n = 9009;

        long start = System.nanoTime();
        faculty(x, n);
        long end = System.nanoTime();
        System.out.println("Oppgave 1: \nTotal runtime: " + (end - start) + " nanoseconds\n" );

        long start2 = System.nanoTime();
        faculty2(x, n);
        long end2 = System.nanoTime();
        System.out.println("Oppgave 2: \nTotal runtime: " + (end2 - start2) + " nanoseconds\n");

        long start3 = System.nanoTime();
        mathPow(x, n);
        long end3 = System.nanoTime();
        System.out.println("Oppgave 3: \nTotal runtime: " + (end3 - start3) + " nanoseconds\n");

    }
}

//    public static void quicksort(int[] t, int v, int h){
//        if(h-v > 2){
//
//            int delepos = split(t,v,h);
//            int min = 9999;
//            int max = 0;
//
//            for(int i = v; i<delepos-1;i++){
//
//
//                if(t[i]<min) min = t[i];
//                if(t[i]>max) max = t[i];
//
//                if(max-min > delepos-1-v){
//                    quicksort(t,v,delepos-1);
//                }
//                if(i==delepos-1){
//                    countsortInt(t, max, v, delepos-1);
//                }
//            }
//            int min2 = 9999;
//            int max2 = 0;
//            for(int i = delepos+1; i<=h;i++){
//                min2 = t[delepos+1];
//                max2 = t[delepos+1];
//
//                if(t[i]<min2) min2 = t[i];
//                if(t[i]>max2) max2 = t[i];
//
//                if(max2-min2 > h-(delepos+1)){
//                    quicksort(t,delepos,h);
//                }
//                if(i==h){
//                    countsortInt(t, max, delepos,h);
//                }
//            }
//
//        }
//        else median3sort(t,v,h);
//    }