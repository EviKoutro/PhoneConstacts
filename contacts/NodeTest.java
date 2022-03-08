package gr.aueb.elearn.chap13.generics;

public class NodeTest {
    public static void main(String[] args) {
        Node intNode = new Node(10);
        Node stringNode = new Node("ABC");

        String s = (String) stringNode.getItem();
        int i = (int) intNode.getItem();

        int j = (int) stringNode.getItem();
    }
}
