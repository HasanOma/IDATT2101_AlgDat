package Oving8;

public class BitString {
    int length;
    long bits;

    public BitString(int length, long bits) {
        this.length = length;
        this.bits = bits;
    }

    public BitString(int length, byte bits) {
        this.length = length;
        this.bits = toLong(bits, length);
    }

    public static BitString connect(BitString b1, BitString b2){
        int length = b1.length+ b2.length;
        long bit = b2.bits | (b1.bits << b2.length);
        if (length > 64){
            throw new IllegalArgumentException("Bitstring too long");
        }
        return new BitString(length, bit);
    }

    public long toLong(byte bits, int length){
        long t = 0;
        for (int i = 1 << length-1; i != 0; i >>= 1) {
            if ((bits & i) == 0){
                t = (t << 1);
            } else {
                t = ((t << 1) | 1);
            }
        }
        return t;
    }
}
