package Oving8;

import java.util.Comparator;

public class HNode implements Comparator<HNode> {
    int value;
    char aChar;

    HNode right;
    HNode left;

    public HNode(int value, char c) {
        this.value = value;
        this.aChar = c;
        this.left = null;
        this.right = null;
    }

    public HNode(){
    }

    @Override
    public int compare(HNode o1, HNode o2) {
        return o1.value - o2.value;
    }
}
