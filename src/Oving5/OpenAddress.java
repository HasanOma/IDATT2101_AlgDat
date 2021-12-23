package Oving5;

public abstract class OpenAddress {
    static class NumberHash{
        private int number;

        public NumberHash(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }
    }

    private NumberHash[] table;
    private final int INITIALCAPASITY = (int)Math.pow(2, 24);
    private final double MAXCAPACITY = 0.99;
    private double nrOfKeys, collisions = 0.0;
    private boolean isPrime;

    public OpenAddress(int capacity) {
        if (capacity < 10000000){
            throw new IllegalArgumentException("Capacity cannot be under 10 million!");
        }else if (capacity%2 == 0){
            table = new NumberHash[INITIALCAPASITY];
            isPrime = false;
        } else {
            table = new NumberHash[capacity];
            isPrime = true;
        }
    }

    protected abstract int probe(int hash, int sHash, int index, int m);

    public double getCollisions() {
        return collisions;
    }

    public double getMAXCAPACITY() {
        return MAXCAPACITY;
    }

    public boolean isPrime() {
        return isPrime;
    }

    public int basicHash(int number){
        int basicHash = number%table.length;
        if (basicHash < 0){
            basicHash*=-1;
        }
        return basicHash;
    }

    public int secondHash(int number){
        int secondHash;
        if (isPrime) {
           secondHash = (number % (table.length - 1)) + 1;
        }else {
            secondHash = (2*number+1) % table.length;
        }
        if (secondHash == 0 || secondHash == table.length){
            secondHash = 1;
        }
        return secondHash;
    }

    public void add(NumberHash numberHash){
        int firstHash = basicHash(numberHash.number);
        if (nrOfKeys/table.length >= getMAXCAPACITY()){
            return;
        }
        if (table[firstHash] == null){
            table[firstHash] = numberHash;
            nrOfKeys++;
        } else {
            int secondHash = secondHash(firstHash);
            int pos = 0;
            collisions++;
            int check = probe(firstHash, secondHash, pos,  table.length);
            while (table[check] != null){
                collisions++;
                check = probe(firstHash, secondHash, pos, table.length);
                pos++;
            }
            table[check] = numberHash;
            nrOfKeys++;
        }
    }


}
