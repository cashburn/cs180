public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        String value;
        Node link;

        Node(String value) {
            this.value = value;
            size++;
        }
    }

    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    public void add(String s) {
        Node n = new Node(s);
        if (head == null)
            head = n;
        if (tail != null)
            tail.link = n;
        tail = n;
    }

    public int getSize() {
        return size;
    }

    public String[] toArray() {
        String[] a = new String[size];
        int i = 0;
        Node n = head;
        while (n != null) {
            a[i++] = n.value;
            n = n.link;
        }
        return a;
    }
}