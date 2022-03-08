package gr.aueb.elearn.chap13.supermarket;

import java.util.Comparator;

public class SortByProductQuantity implements Comparator<IProduct> {
    @Override
    public int compare(IProduct o1, IProduct o2){
        return (o1.getQuantity() - o2.getQuantity());
    }
}
