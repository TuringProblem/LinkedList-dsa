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

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() { System.out.printf("Head: %d\n", head.value); }
    public void getTail() { System.out.printf("Tail: %d\n", tail.value); }
    public void getLength() {  System.out.printf("Length: %d\n ", length); }
}
