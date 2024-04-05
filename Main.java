import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(15);
        list.getHead();
        list.getTail();
        list.getLength();
        list.prepend(14);
        list.getLength();
        list.printList();
        System.out.println(list.removeFirst().value + "\n");
        list.printList();
    }
}
