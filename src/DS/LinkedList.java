package DS;

public class LinkedList {
    private Node head;
    private Node tail;
    public int length;

    public LinkedList() {
        this.length = 0;
    }

    public boolean append(int value) {
        Node new_tail = new Node(value);
        if (this.length == 0) {
            this.head = this.tail = new_tail;
        } else {
            Node prev_tail = this.tail;
            prev_tail.next = new_tail;
            this.tail = new_tail;
        }

        this.length++;
        return false;
    }

    public boolean prepend(int value) {
        Node new_head = new Node(value);
        if (this.length == 0) {
            this.head = this.tail = new_head;
        } else {
            new_head.next = this.head;
            this.head = new_head;
        }

        this.length++;
        return true;
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

    public boolean set(int index, int value) {
        Node target_node = this.get(index);
        if (target_node == null) {
            return false;
        }

        target_node.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        if(index < 0 || index > this.length) {
            return false;
        }

        if(index == this.length) {
            return this.append(value);
        }
        if(index == 0) {
            return this.prepend(value);
        }

        Node prev_node = this.get(index-1);
        Node next_node = prev_node.next;

        Node target_node = new Node(value);
        prev_node.next = target_node;
        target_node.next = next_node;

        this.length++;
        return true;
    }

    public Node remove(int index) {
        if(index < 0 || index >= this.length) {
            return null;
        }

        if(index == 0) {
            return this.popFirst();
        }
        if(index == this.length-1) {
            return this.pop();
        }

        Node prev_node = this.get(index-1);
        Node target_node = prev_node.next;
        prev_node.next = target_node.next;
        target_node.next = null;

        this.length--;
        return target_node;
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

    public Node popFirst() {
        if (this.length == 0) {
            this.length--;
            return null;
        }

        Node prev_head = this.head;
        if (this.length == 1) {
            this.head = this.tail = null;
        } else {
            this.head = prev_head.next;
        }

        this.length--;
        return prev_head;
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

    public class Node {
        protected int value;
        protected Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
