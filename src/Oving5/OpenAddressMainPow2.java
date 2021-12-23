package Oving5;

import java.util.ArrayList;

public class OpenAddressMainPow2 {
    public static void main(String[] args) {
        int prime = (int)Math.pow(2, 24);
        int nrToAdd;
        ArrayList<OpenAddress.NumberHash> numberHList = new ArrayList<>();
        System.out.println("99% table completion");
        numberHList.add(0,new OpenAddress.NumberHash(10));
        for (int i = 1; i <= prime; i++) {
            nrToAdd = numberHList.get(i-1).getNumber()+(1 + (int)(Math.random() * ((1000000 - 1) + 1)));
            numberHList.add(i, new OpenAddress.NumberHash(nrToAdd));
        }

        OpenAddressLinearProb linearProb = new OpenAddressLinearProb(prime);
        long start = System.nanoTime();
        for (int i = 0; i < prime; i++) {
            linearProb.add(numberHList.get(i));
        }
        long end = System.nanoTime();
        System.out.println("Time linear probing with power of 2 table length: " + (end-start)/1000000 + " ms");
        System.out.println("Number of collisions: " + linearProb.getCollisions() + "\n");


        OpenAddressQuadProb quadProb = new OpenAddressQuadProb(prime);
        long start2 = System.nanoTime();
        for (int i = 0; i < prime; i++) {
            quadProb.add(numberHList.get(i));
        }
        long end2 = System.nanoTime();
        System.out.println("Time quadratic probing with power of 2 table length: " + (end2-start2)/1000000 + " ms");
        System.out.println("Number of collisions: " + quadProb.getCollisions() + "\n");


        OpenAddressDHashing dHashing = new OpenAddressDHashing(prime);
        long start3 = System.nanoTime();
        for (int i = 0; i < prime; i++) {
            dHashing.add(numberHList.get(i));
        }
        long end3 = System.nanoTime();
        System.out.println("Time Double hashing with power of 2 table length: " + (end3-start3)/1000000 + " ms");
        System.out.println("Number of collisions: " + dHashing.getCollisions() + "\n");


    }
}
