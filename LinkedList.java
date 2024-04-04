public class LinkedList {
    private Node tail;
    private Node head;
    private int length;
    
    class Node{
        int value;
        Node next;
        public Node(int value) { this.value = value; }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }
    public void append(int value) {
        Node newNode = new Node(value);
    }
    public void  prepend(int value) {
        Node newNode = new Node(value);
    }
    public boolean insert(int index, int value) {
        Node newNode = new Node(value); 
        return false;
    }
}
