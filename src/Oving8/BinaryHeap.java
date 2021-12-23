package Oving8;

import java.util.PriorityQueue;

public class BinaryHeap {
    int length;
    PriorityQueue<HNode> heap;

    public BinaryHeap(int length) {
        this.length = length;
        this.heap = new PriorityQueue<>(new HNode());
    }

    public BinaryHeap buildHeap(int[] val){
        for (int i = 0; i < val.length; i++) {
            if (val[i] == 0){
                continue;
            }
            char curr = (char) i;
            int value = val[i];
            HNode hNode = new HNode(value, curr);
            heap.add(hNode);
        }
        return this;
    }

    public HNode poll(){
        return heap.poll();
    }

    public void add(HNode root){
        heap.add(root);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        PriorityQueue<HNode> copy = new PriorityQueue<>(heap);
        while (!copy.isEmpty()){
            str.append(copy.poll().toString());
        }
        return str.toString();
    }
}

