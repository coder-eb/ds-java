package DS;

import org.w3c.dom.Node;

public class LinkedList {
    private Node head;
    private Node tail;
    public int length;

    public LinkedList() {
        this.length = 0;
    }

    public void append(int value) {
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

    public void prepend(int value) {
        Node new_head = new Node(value);
        if (this.length == 0) {
            this.head = this.tail = new_head;
        } else {
            new_head.next = this.head;
            this.head = new_head;
        }

        this.length++;
    }

    public Node get(int index) {
        if(this.length == 0 || index >= this.length) {
            return null;
        }

        Node pointer = this.head;
        for(int i=0; i<index; i++) {
            pointer = pointer.next;
        }
        return pointer;
    }

    public Node pop() {
        if (this.length == 0) {
            return null;
        }

        Node prev_tail = this.tail;
        if (this.length == 1) {
            this.head = this.tail = null;
        } else {
            Node new_tail = this.get(this.length-2);
            new_tail.next = null;
            this.tail = new_tail;
        }

        this.length--;
        return prev_tail;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node pointer = this.head;
        while(pointer != null) {
            stringBuilder.append(pointer.value);
            stringBuilder.append(" -> ");
            pointer = pointer.next;
        }
        stringBuilder.append("END");
        return stringBuilder.toString();
    }

    public void display() {
        System.out.println(this);
    }

    class Node {
        protected int value;
        protected Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
