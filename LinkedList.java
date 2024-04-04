import java.util.function.Predicate;

public class LinkedList {
    private Node tail;
    private Node head;
    private int length;
    
    class Node{
        int value;
        Node next;
        public Node(int value) { this.value = value; }
    }
    public LinkedList() {
        head = null;
        tail = null;
        length = 0;
    }
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }
    public void append(int value) {
        //create a node
        Node newNode = new Node(value);
        //account for if the LinkedList has no Nodes
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else { //Assign the last Node to the new Node using tail.next -> then tail = newNode
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    public void  prepend(int value) {
        //create a new Node
        Node newNode = new Node(value);
        if (length == 0) { //account for if the LinkedList is empty.
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
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
