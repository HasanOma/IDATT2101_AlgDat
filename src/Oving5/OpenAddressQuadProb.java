package Oving5;

public class OpenAddressQuadProb extends OpenAddress{
    private int x = 5;

    public OpenAddressQuadProb(int capacity) {
        super(capacity);
    }

    @Override
    protected int probe(int hash, int sHash, int index, int m) {
        return (int)(hash + x*index + x*Math.pow(index,2))%m;
    }
}
