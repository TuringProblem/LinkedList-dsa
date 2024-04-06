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
    //going to make two variable for iterating through the Nodes, using "pre" and "temp"
    public Node removeLast() {
        if (length == 0) return null;
        Node temp = head;
        Node pre = head;
        while (temp.next != null) {//iterates temp to go through the Linked List and see if the values are not null
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;
        if  (length == 0) {//this edge case checks if the length is 0 after decrementing through the LinkedList
            head = null;
            tail = null;
        }
        return temp;
    }

    public Node removeFirst() {
        if (length == 0) return null; //if the length of the list is - 0 - then return null -> can also do if head == null, return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) { //now if the length  == 0 then all we need to do is push tail to null value
            tail = null; //need to do this because tail will still be pointing to the node that is now gone
        }
        return temp;
    }
    public void  prepend(int value) {
        //create a new Node
        Node newNode = new Node(value);
        if (length == 0) { //account for if the LinkedList is empty.
            head = newNode;
            tail = newNode;
        } else {
            /**
             *Assign the first Node (newNode.next) -> (next being the pointer) to the head (which points to the first Node)
             *  && assign head to the newNode being added to the beginning of the list
             */
            newNode.next = head;
            head = newNode;
        }
        length++;
    }
    public Node get(int index) {
        if (index < 0 || index >= length) return null; //making sure that the index set by the user is in range
       Node temp = head;
       for (int i = 0; i < index; i++) { //iterate through the specific index.
           temp = temp.next;
       }
       return temp;
    }
    public boolean set(int index, int value) {
        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;
        if (index == 0) { //if adding something to the beginning
            prepend(value);
            return true;
        }
        if (index == length){ //if adding something to the end
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next  = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next; //This allows the Node that prev is pointing to -> to remove the node that temp is pointing to.
        temp.next = null; //This makes the Node that temp is on to point at null
        length--;
        return temp;
    }

    public void reverse() { //Reverses the linked list by using temp, after, and before Nodes
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) { // This for loop iterates through the three Temporary Nodes created.
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.printf("%d\n",temp.value);
            temp = temp.next;
        }
    }

    public void getHead() { System.out.printf("Head: %d\n", head.value); }
    public void getTail() { System.out.printf("Tail: %d\n", tail.value); }
    public void getLength() {  System.out.printf("Length: %d\n ", length); }
}
