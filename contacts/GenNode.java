package gr.aueb.elearn.chap13.generics;

import java.io.Serializable;

public class GenNode<E> {
    private E item;
    private GenNode<E> next = null;

    public GenNode(E item) {
        this.item = item;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "GenNode{" +
                "item=" + item;
    }
}

/*

public class GenNode{
    private Number item;
    private GenNode next;

    public GenNode(Number item) {
        this.item = item;
   }

   public Number getItem() {
        return item;
    }

    public void setItem(Number item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "GenNode{" +
                "item=" + item;
    }




*/

