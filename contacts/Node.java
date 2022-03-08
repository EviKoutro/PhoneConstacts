package gr.aueb.elearn.chap13.generics;

public class Node {
    private Object item;
    private Node next = null;

    public Node(Object item) {
        this.item = item;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item;
    }
}
