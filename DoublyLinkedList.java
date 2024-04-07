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
    public Node removeFirst() {
        if (length == 0) return null; //Edge case for if there is no Node in the list
        Node temp = head;
       if (length == 1) { //Edge case if the list only has one Node
           head = null;
           tail = null;
       } else {
           head = head.next;
           head.prev = null; //This breaks the connection  from the new first Node to the Node being removed
           temp.next = null; //This breaks the connection of the first Node to the new First Node
       }
       length--;
       return temp;
    }
    public Node get(int index) { //This is the more efficient way for the DLL to parse through the get method
        if (index < 0 || index >= length) return null;
        Node temp = head;
        if (index < length / 2) { //this checks if the Node is on the left side of the index
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else { //if the index is greater than the half-way point, than the index will start on the right side where the tail is.
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) { //This is the same exact method seen in the LinkedList, but the difference is the get method in the DLL compared to the LinkedList
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next; //o(1) way of getting to the Node after before
        newNode.prev = before; //Points the back pointer to the before Node
        newNode.next = after; //Points the front pointer to the pointer after
        before.next = newNode; //Points the before.next pointer to the new Node that is being added
        after.prev = newNode; //Points the after back pointer to the new Node being added
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();
        Node temp = get(index);
        temp.next.prev = temp.prev; //You could make the before, and after node -> this allows you to use one node because you are using a DLL
        temp.prev.next = temp.next; //temp.next.prev && temp.prev.next are the value before/after pointers to make them point at each other.
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    public void getHead(){ System.out.printf("Head: %d", head.value); }
    public void getTail(){ System.out.printf("Tail: %d", tail.value); }
    public void getLength() { System.out.printf("Length: %d", length); }
}
