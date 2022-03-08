package gr.aueb.elearn.chap13.generics;

public class GenNodeTest {
    public static void main(String[] args) {
        GenNode<Integer> intNode = new GenNode<>(10);
        GenNode<Integer> intNode2 = new GenNode<>(12);
        GenNode<Float> floatNode = new GenNode<>(5.4F);

        //GenNode<String> stringNode = new GenNode<>("ABC");
        //GenNode<?> unknown = new GenNode<>(12);

        //String s = stringNode.getItem();
        int i = intNode.getItem();

        //int j = (int) stringNode.getItem();

        //System.out.println(intNode);
        //System.out.printf("%s", stringNode);

        printItems(intNode, intNode2);
        swap(intNode, intNode2);
        printItems(intNode, intNode2);

    }

    public static <E> void swap(GenNode<E> item1, GenNode<E> item2){
        E tmp = item1.getItem();
        item1.setItem(item2.getItem());
        item2.setItem(tmp);
    }

    public  static void printItems(GenNode<?> item1, GenNode<?> item2){
        System.out.printf("item1: %s - item2: %s\n", item1.getItem(), item2.getItem());
    }
}
