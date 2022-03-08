package gr.aueb.elearn.chap13.supermarket;

import java.util.Comparator;

public class SortByProductPrice implements Comparator<IProduct> {
    @Override
    public int compare(IProduct o1, IProduct o2){
        if (o1.getProductPrice() < o2.getProductPrice() ) return -1;
        else if (o1.getProductPrice() == o2.getProductPrice()) return 0;
        else return 1;
    }
}
