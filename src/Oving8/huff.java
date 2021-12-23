package Oving8;

public class huff {
//    private int[] frequency;
//    private String[] bitStrings;
//    private List<Byte> encodedList;
//    private DataOutputStream outputStream;
//
//    public huff() {
//        this.frequency = new int[256];
//        this.bitStrings = new String[256];
//        encodedList = new ArrayList<>();
////        Arrays.fill(bitStrings, "");
//    }
//
//    public void compress(byte[] bytes, String outString) throws IOException {
//        for (int i : bytes) {
//            if (i < 0)
//                frequency[256 + i]++;
//            else
//                frequency[i]++;
//        }
//
//        HNode root = buildHeap();
//        encodeTree(root, "");
//        outputStream = new DataOutputStream(new FileOutputStream(outString));
//
//        for (int i : frequency) {
//            outputStream.writeInt(i);
//        }
//
//        int input;
//        int i = 0;
//        int j;
//        int k;
//        long currB = 0L;
//
//        for (j = 0; j < bytes.length; j++) {
//            input = bytes[j];
//            if (input < 0){
//                input += 256;
//            }
//
//            String str = bitStrings[input];
//            k=0;
//
//            while (k < str.length()) {
//                if (str.charAt(k) == '0') {
//                    currB = (currB << 1);
//                } else currB = ((currB << 1) | 1);
//                ++k;
//                ++i;
//                if (i == 8) {
//                    encodedList.add((byte) currB);
//                    i = 0;
//                    currB = 0L;
//                }
//            }
//
//        }
//        int l = i;
//        while (i < 8 && i != 0) {
//            currB = (currB << 1);
//            ++i;
//        }
//        encodedList.add((byte) currB);
//
//        outputStream.writeInt(l);
//
//        for (Byte b: encodedList) {
//            outputStream.write(b);
//        }
//
//        outputStream.close();
//    }
//
//    public void encodeTree(HNode root, String str){
//        if (root.left == null && root.right == null){
//            bitStrings[root.aChar] = str;
//            return;
//        }
//        encodeTree(root.left, str + "0");
//        encodeTree(root.left, str + "1");
//    }
//
//    public HNode buildHeap(){
//        BinaryHeap binaryHeap = new BinaryHeap(frequency.length);
//        binaryHeap.buildHeap(frequency);
//
//        HNode root = new HNode();
//        while (!(binaryHeap.heap.size()==1)){
//            HNode left = binaryHeap.min();
//            HNode right = binaryHeap.min();
//
//            HNode top = new HNode(left.value + right.value, '\0');
//
//            top.left = left;
//            top.right = right;
//
//            binaryHeap.insert(top);
//
//            root = top;
//        }
//
//        return root;
//    }

//    public byte[] decompress(String file) throws IOException {
//        DataInputStream inputStream = new DataInputStream(new FileInputStream(file));
//        frequency = new int[MAX_INT];
//        for (int i = 0; i < frequency.length; i++) {
//            int freq = inputStream.readInt();
//            frequency[i] = freq;
//        }
//
//        int l = inputStream.readInt();
//        HNode hNode = createHeap();
//
//        byte aByte;
//        byte[] bytes = inputStream.readAllBytes();
//        inputStream.close();
//
//        int byteLength = bytes.length;
//
//        if (l > 0)
//            byteLength--;
//
//        ArrayList<Byte> bytesOut = new ArrayList<>();
//        BitString bitString = new BitString(0, 0);
//
//        for (int i = 0; i < byteLength; i++) {
//            aByte = bytes[i];
//            BitString string = new BitString(8, aByte);
//            bitString = BitString.connect(bitString, string);
//            bitString = writeCharactersTo(hNode, bitString, bytesOut);
//        }
//
//        if (l > 0) {
//            BitString bitStringTwo = new BitString(l, bytes[byteLength] >> (8 - l));
//            bitString = BitString.connect(bitString, bitStringTwo);
//            writeCharactersTo(hNode, bitString, bytesOut);
//        }
//
//        byte[] bArr = new byte[bytesOut.size()];
//        for (int i = 0; i < bytesOut.size(); i++)
//            bArr[i] = bytesOut.get(i);
//
//        return bArr;
//    }
//
//    private static BitString writeCharactersTo(HNode tree, BitString bitstring, ArrayList<Byte> decompressedBytes) {
//        HNode tempTree = tree;
//        int c = 0;
//
//        for (long j = 1 << bitstring.length - 1; j != 0; j >>= 1) {
//            c++;
//            if ((bitstring.bits & j) == 0)
//                tempTree = tempTree.left;
//            else
//                tempTree = tempTree.right;
//
//            if (tempTree.left == null) {
//                long character = tempTree.aChar;
//                decompressedBytes.add((byte) character);
//                long temp = ~(0);
//                bitstring.bits = (bitstring.bits & temp);
//                bitstring.length = bitstring.length - c;
//                c = 0;
//                tempTree = tree;
//            }
//        }
//
//        return bitstring;
//    }
}
