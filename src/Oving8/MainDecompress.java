package Oving8;

import java.io.IOException;

public class MainDecompress {
    public static void main(String[] args) throws IOException {
        String compressed = "";
        String deCompressed = "";

        Huffman huffman = new Huffman();
        byte[] bytes = huffman.decompress(compressed);

        LZ77 lz77 = new LZ77();
        lz77.decompress(bytes, deCompressed);
    }
}
