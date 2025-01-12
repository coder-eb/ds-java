package DS;

public class LinkedList<T> {
    private Node head;
    private Node tail;
    public int length;

    public LinkedList() {
        this.length = 0;
    }

    public void append(T value) {
        Node new_tail = new Node(value);
        if (this.length == 0) {
            this.head = this.tail = new_tail;
        } else {
            Node prev_tail = this.tail;
            prev_tail.next = new_tail;
            this.tail = new_tail;
        }

        this.length++;
    }

    public void display() {
        StringBuilder stringBuilder = new StringBuilder();
        Node pointer = this.head;
        while(pointer != null) {
            stringBuilder.append(pointer.value);
            stringBuilder.append(" -> ");
            pointer = pointer.next;
        }
        stringBuilder.append("END");
        System.out.println(stringBuilder);
    }

    class Node {
        protected T value;
        protected Node next;

        Node(T value) {
            this.value = value;
        }
    }
}
