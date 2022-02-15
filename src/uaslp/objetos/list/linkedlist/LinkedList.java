package uaslp.objetos.list.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addAtTail(String data) {
        Node node = new Node ();

        node.data = data;

        if(size == 0) {
            head = node;
        } else {
            tail.next = node;
            node.previous = tail;
        }

        tail = node;
        size ++;
    }

    public void addAtFront(String data) {

    }

    public void remove(int index) {

    }

    public void removeAll() {

    }

    public void setAt(int index, String data) {

    }

    public String getAt(String index) {
        return  null;
    }

    public void removeAllWithValue(String data) {

    }

    public void getSize() {

    }

    public LinkedListIterator getIterator() {
        return null;
    }
}
