package Oving8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Huffman {

    private int[] frequency;
    private String[] bitStrings;
    private List<Byte> encodedByteList;
    private DataOutputStream outputStream;
    private static final int MAX_INT = 256;

    public Huffman() {
        this.frequency = new int[MAX_INT];
        this.bitStrings = new String[MAX_INT];
        encodedByteList = new ArrayList<>();
    }

    public void compress(byte[] bytes,  String outToFile) throws IOException {
        for (int i : bytes) {
            if (i < 0) frequency[MAX_INT + i]++;
            else frequency[i]++;
        }
        HNode root = createHeap();
        encodeTree(root, "");
        outputStream = new DataOutputStream(new FileOutputStream(outToFile));

        for (int i : frequency){
            outputStream.writeInt(i);
        }

        int byteInput;
        int i = 0;
        int j;
        int k;
        long currB = 0L;
        for (j = 0; j < bytes.length; j++) {
            byteInput = bytes[j];
            if (byteInput < 0){
                byteInput += MAX_INT;
            }

            String str = bitStrings[byteInput];
            k = 0;

            while (k < str.length()) {
                if (str.charAt(k) == '0') currB = (currB << 1);
                else currB = ((currB << 1) | 1);
                ++k;
                ++i;
                if (i == 8) {
                    encodedByteList.add((byte) currB);
                    i = 0;
                    currB = 0L;
                }
            }

        }

        int l = i;
        while (i < 8 && i != 0) {
            currB = (currB << 1);
            ++i;
        }

        encodedByteList.add((byte) currB);

        outputStream.writeInt(l);

        for (Byte b : encodedByteList)
            outputStream.write(b);

        outputStream.close();
    }

    private void encodeTree(HNode root, String str) {
        if (root.left == null && root.right == null) {
            bitStrings[root.aChar] = str;
            return;
        }

        encodeTree(root.left, str + "0");
        encodeTree(root.right, str + "1");
    }

    private HNode createHeap() {
        BinaryHeap binaryHeap = new BinaryHeap(frequency.length);
        binaryHeap.buildHeap(frequency);

        HNode root = new HNode();
        while (!(binaryHeap.heap.size() == 1)) {
            HNode left = binaryHeap.poll();
            HNode right = binaryHeap.poll();
            int topVal = left.value + right.value;
            HNode top = new HNode(topVal,'\0' );

            top.left = left;
            top.right = right;

            binaryHeap.add(top);

            root = top;
        }

        return root;
    }

    public BitString charForNode(HNode hNode, BitString bitStr, ArrayList<Byte> bytes){
        HNode tempHNode = hNode;
        int s = 0;
        for (long i = 1 << bitStr.length-1; i != 0; i >>= 1) {
            s++;
            if ((bitStr.bits & i) == 0) tempHNode = tempHNode.left;
            else tempHNode = tempHNode.right;
            if (tempHNode.left == null){
                long val = tempHNode.aChar;
                bytes.add((byte) val);
                long curr = (long) ~ (0);
                bitStr.bits = (bitStr.bits & curr);
                bitStr.length = bitStr.length - s;
                s = 0;
                tempHNode = hNode;
            }
        }
        return bitStr;
    }

    public byte[] decompress(String file) throws IOException {
        DataInputStream inputStream = new DataInputStream(new FileInputStream(file));
        frequency = new int[MAX_INT];
        for (int i = 0; i < frequency.length; i++) {
            int occurrence = inputStream.readInt();
            frequency[i] = occurrence;
        }
        ArrayList<Byte> bytesOut = new ArrayList<>();
        int last = inputStream.readInt();

        HNode hNode = createHeap();
        byte b;
        byte[] bytes = inputStream.readAllBytes();
        inputStream.close();
        int byteLength = bytes.length;
        BitString bitString = new BitString(0,0);

        if (last > 0){
            byteLength--;
        }

        for (int i = 0; i < byteLength; i++) {
            b = bytes[i];
            BitString bString = new BitString(8,b);
            bitString = BitString.connect(bitString, bString);
            bitString = charForNode(hNode, bitString, bytesOut);
        }

        if (last > 0){
            BitString bitString2 = new BitString(last, bytes[byteLength] >> (8-last));
            bitString = BitString.connect(bitString, bitString2);
            charForNode(hNode, bitString, bytesOut);
        }

        byte[] bArr = new byte[bytesOut.size()];
        for (int i = 0; i < bytesOut.size(); i++) {
            bArr[i] = bytesOut.get(i);
        }

        return bArr;
    }
}