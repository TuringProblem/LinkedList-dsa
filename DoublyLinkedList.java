import java.util.function.Predicate;

public class DoublyLinkedList {
    class Node {
        int value;
        Node next;
        Node prev;
        public Node(int value) {this.value = value;}
    }
    Node head;
    Node tail;
    int length;
    public DoublyLinkedList(int value) { //This is the constructor for the DoublyLinkedList
        Node newNode = new Node(value);
        head = newNode;
        tail  = newNode;
        length = 1;
    }
    public void append(int value) { //creates a Node at the end of the DoublyLinkedList
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode; //adds the node to the list.
        }
        length++;
    }
    public Node removeLast() {
        if (length == 0) return null; //for when we have 0 items in the list...
        Node temp = tail;
        if (length == 1) { //this is the edge case if the list only has 1 Node...
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;//Makes the new tail Node point to null, moving the last Node from the list
            temp.prev = null;//Pulls the prev pointer off of the new tail Node
        }
        length--;
        return temp;
    }

    public void prepend(int value) { //adding the Node to the beginning of the list
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode; //adds the value to the linkedList
        }
        length++;
    }

    public void getHead(){ System.out.printf("Head: %d", head.value); }
    public void getTail(){ System.out.printf("Tail: %d", tail.value); }
    public void getLength() { System.out.printf("Length: %d", length); }
}
