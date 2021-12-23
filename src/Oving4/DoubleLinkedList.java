package Oving4;

//4.3-3
public class DoubleLinkedList {

    static class Node {
        private final int element;
        private Node prev;
        private Node next;

        public Node(int i) {
            this.element = i;
        }
    }

    private static int size;
    private static Node head;
    private static Node tail;

    public static int getSize(){
        return size;
    }

    public static boolean isEmpty(){
        return getSize() == 0;
    }

    public static Node add(Node elem, int i) {
        return addLast(elem, i);
    }

    public static Node addLast(Node elem, int i) {
        if (isEmpty()) {
            Node newNode = new Node(i);
            newNode.next = newNode.prev = newNode;
            head = newNode;
            size++;
            elem = newNode;
            return elem;
        } else {
            tail = head.prev;
            Node newNode = new Node(i);
            newNode.next = head;
            head.prev = newNode;
            newNode.prev = tail;
            tail.next = newNode;
        }
        size++;
        return tail;
    }

    public static Node addFirst(Node elem, int i) {
        if (isEmpty()) {
            Node newNode = new Node(i);
            newNode.next = newNode.prev = newNode;
            head = newNode;
            size++;
            return newNode;
        } else {
            tail = head.prev;
            Node newNode = new Node(i);
            newNode.next = head;
            newNode.prev = tail;
            tail.next = head.prev = newNode;
            head = newNode;
        }
        size++;
        return head;
    }

    static void printNodes(Node head) {
        Node trav = head;
        if (head != null) {
            do {
                System.out.print(trav.prev.element + " <-- " + trav.element + " --> " + trav.next.element + "  ");
                trav = trav.next;
            } while (trav != head);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node start = null;
        for (int i = 0; i < 10; i++) {
        start = addFirst(start,i);
        }
        printNodes(start);
    }
}