package Oving4;
//4.3-5
public class Josephus {
    static class Node {
        private int element;
        private Node next;

        public Node(int element) {
            this.element = element;
        }

        @Override
        public String toString() {
            return "Node: " +element;
        }
    }

    private static int size = 0;
    private static Node head;
    private static Node tail;

    public Josephus() {
    }

    public static int getSize(){
        return size;
    }

    public static Node addAList(Node elem, int i) {
        Node newNode = new Node(i);
        System.out.println(i + " added");
        head = newNode;
        Node thisNode = head;
        for (int j = 2; j <= 41; j++) {
            thisNode.next = new Node(j);
            thisNode = thisNode.next;
            thisNode.next = head;
            tail = thisNode;
            size++;
            System.out.println(j + " added");

        }
        printNodes(elem);
        return head;
    }

    static void printNodes(Node head) {
        Node trav = head;
        if (head != null) {
            do {
                System.out.print(trav.element + " ");
                trav = trav.next;
            } while (trav != head);
        }
        System.out.println();
    }

    public static int remove(int k){
        Node curr = head;
        Node trav = tail;
        for (int i = 1; i < size ; i++) {
            for (int j = 1; j < k; j++) {
                trav = trav.next;
                curr = curr.next;
                if (j==k-1) {
                    curr.next = curr.next.next;
                    curr = null;
                    trav = trav.next;
                    curr = trav.next;
                    printNodes(curr);
                }
            }
        }
        return curr.element;
    }

    public static void main(String[] args) {
        Node head = null;
            head = addAList(null, 1);
            size++;

        printNodes(head);

        System.out.println(remove(2));
    }
}