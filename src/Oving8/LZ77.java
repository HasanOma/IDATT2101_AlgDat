package Oving8;

import java.io.*;
import java.util.ArrayList;

public class LZ77 {

    private final int MIN_LENGTH = 3;

    public static byte[] listToArray(ArrayList<Byte> out) {
        int length = out.size();
        byte[] result = new byte[length];
        for (int i = 0; i < length; i++) {result[i] = out.get(i);}
        return result;
    }

    public byte[] compress(String path) throws IOException {
        DataInputStream inputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(path)));
        byte[] data = inputStream.readAllBytes();

        ArrayList<Byte> compressed = new ArrayList<>();
        byte unchanged = MIN_LENGTH;
        int i;

        for (i = MIN_LENGTH; i < data.length; i++) {
            boolean found = false;
            short distance = 0;
            byte foundLength = 0;
            for (short d = 3; d <= i && d < Short.MAX_VALUE; d++) {
                if (data[i - d] == data[i]) {
                    int foundLengthInt;

                    for (foundLengthInt = 1; foundLengthInt < d
                            && foundLengthInt < Byte.MAX_VALUE
                            && i + foundLengthInt < data.length;) {
                        if (data[i + foundLengthInt] == data[i - d + foundLengthInt]) {foundLengthInt++;}
                        else {break;}

                    }
                    if (foundLengthInt > MIN_LENGTH && foundLengthInt > foundLength) {
                        found = true;
                        foundLength = (byte)foundLengthInt;
                        distance = d;
                        if (foundLength == Byte.MAX_VALUE) {break;}
                    }
                }
            }
            if (found) {
                if (unchanged != 0) {
                    compressed.add(unchanged);
                    for (int j = i - unchanged; j < i; j++) {compressed.add(data[j]);}
                    unchanged = 0;
                }
                compressed.add((byte)(-foundLength));
                compressed.add((byte)(distance & 0xff));
                compressed.add((byte)((distance >> 8) & 0xff));

                i += ((int)(foundLength) - 1);
            }
            else {unchanged++;}
            if (unchanged == Byte.MAX_VALUE) {
                compressed.add(unchanged);
                for (int j = i - unchanged + 1; j <= i; j++) {compressed.add(data[j]);}
                unchanged = 0;
            }
        }
        compressed.add(unchanged);
        for (int j = i - unchanged; j < i; j++) {compressed.add(data[j]);}
        inputStream.close();
        return listToArray(compressed);
    }

    public void decompress(byte[] data, String outFile) throws IOException {
        DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(outFile)));
        ArrayList<Byte> decompressed = new ArrayList<>();
        for (int i = 0, indexOut = 0; i < data.length; i++) {
            byte x = data[i];
            if (x < 0) {
                short distance = (short)((data[i + 1] & 0xff) | ((data[i + 2] & 0xff) << 8));
                int start = indexOut;
                for (int j = start - distance; j < start - distance - x; j++) {
                    decompressed.add(decompressed.get(j));
                    indexOut++;
                }
                i += (MIN_LENGTH - 1);
            }
            else {
                for (int j = i + 1; j <= i + x && j < data.length; j++) {
                    decompressed.add(data[j]);
                    indexOut++;
                }
                i += x;
            }
        }

        for (int j = 0; j < decompressed.size(); j++) {
            outputStream.writeByte(decompressed.get(j));
        }
        outputStream.flush();
        outputStream.close();
    }

}