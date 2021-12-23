package Oving5;

public class OpenAddressLinearProb extends OpenAddress{

    public OpenAddressLinearProb(int capacity) {
        super(capacity);
    }

    @Override
    protected int probe(int hash, int sHash, int index, int m) {
        return (hash+index)%m;
    }
}
