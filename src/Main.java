import DS.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.prepend(0);
        ll.pop();

        ll.display();
    }
}