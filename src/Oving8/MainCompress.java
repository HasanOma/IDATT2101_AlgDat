package Oving8;

import java.io.IOException;

public class MainCompress {
    public static void main(String[] args) throws IOException {
        String original = "";
        String compressed = "";

        LZ77 lz77 = new LZ77();
        byte[] compBytes = lz77.compress(original);

        Huffman huffman = new Huffman();
        huffman.compress(compBytes, compressed);
    }
}
