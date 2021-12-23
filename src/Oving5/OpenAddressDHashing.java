package Oving5;

public class OpenAddressDHashing extends OpenAddress{
    public OpenAddressDHashing(int capacity) {
        super(capacity);
    }

    @Override
    protected int probe(int hash, int sHash, int index, int m) {
        int probe = (hash + index*sHash)%m;
        if (probe < 0 ) {
            probe *= -1;
        }
        return probe;
    }
}
