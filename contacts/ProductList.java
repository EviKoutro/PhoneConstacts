package gr.aueb.elearn.chap13.supermarket;

import org.jetbrains.annotations.NotNull;
import java.io.Serializable;
import java.util.*;

public class ProductList implements IProductList, Serializable {
    private static final long serialVersionUID = 12L;

    private final List<IProduct> myGenericIProductList = new ArrayList<>();
    private final List<Product> myProductList = new ArrayList<>();

    ProductList() {}

    @Override
    public boolean addNewProduct(IProduct product) {
        if (this.findProduct(product.getProductBarCode().decodeCode()) < 0) {
            myGenericIProductList.add(product);
            return true;
        } else {
            System.out.println("Product already in List");
            return false;
        }
    }


    @Override
    public boolean updateProduct(IProduct oldProduct, IProduct newProduct) {
        if (oldProduct != null) {
            int foundPosition = this.findProduct(oldProduct.getProductBarCode().decodeCode());
            if (foundPosition < 0) {
                System.out.println("Product not found");
                return false;
            }

            IProduct tmp = this.myGenericIProductList.set(foundPosition, newProduct);
            System.out.println(oldProduct.getProductBarCode().decodeCode() + " was replaced with " +
                    tmp.getProductBarCode().decodeCode());
            return true;
        } else {
            System.out.println("Product was not found");
            return false;
        }
    }


    @Override
    public boolean removeProduct(IProduct product) {
        if (product != null) {
            int foundPosition = this.findProduct(product.getProductBarCode().decodeCode());
            if (foundPosition >= 0) {
                myGenericIProductList.remove(foundPosition);
                System.out.println(product.getProductBarCode().decodeCode() + " was deleted");
                return true;
            } else {
                System.out.println(product.getProductBarCode().decodeCode() + " was not found");
                return false;
            }
        } else {
            System.out.println("Product was not found");
            return false;
        }
    }

    @Override
    public IProduct getProductByName(String productName) {
        for (IProduct p : myGenericIProductList) {
            if (p.getProductName().equals(productName)) return p;
        }
        return null;
    }

    @Override
    public IProduct getProductByBarCode(@NotNull IBarCode barCode) {
        for (IProduct p : myGenericIProductList) {
            if (p.getProductBarCode().equals(barCode)) return p;
        }
        return null;
    }

    @Override
    public boolean productCodeExists(IBarCode barCode) {
        for (IProduct p : myGenericIProductList) {
            if (p.getProductBarCode().equals(barCode)) return true;
        }
        return false;
    }

    @Override
    public void printProductList() {
        myGenericIProductList.forEach(System.out::println);
    }

    private int findProduct(String productBarCode) {
        for (int i = 0; i < this.myGenericIProductList.size(); i++) {
            if (productBarCode.equals(myGenericIProductList.get(i).getProductBarCode().decodeCode()))
                return i;
        }
        return (-1);
    }


    @Override
    public void sortByProductName(){
        for (IProduct p : myGenericIProductList)
            myProductList.add((Product) p);

        System.out.println("Πριν την ταξινόμηση");
        printProductList();

        Collections.sort(myProductList);
        //Collections.sort(myProductList, Comparator.reverseOrder());
        Collections.copy(myGenericIProductList, myProductList);

        System.out.println("Μετά την ταξινόμηση");
        printProductList();

    }

    @Override
    public void sortProductsByProductPrice(){

        System.out.println("Πριν την ταξινόμηση");
        printProductList();

        myGenericIProductList.sort(new SortByProductPrice());
        //Collections.sort(myGenericIProductList, new SortByProductPrice());
        // Για descending ordering
        //Collections.sort(myProductList, new SortByProductPrice().reversed());

        System.out.println("Μετά την ταξινόμηση");
        printProductList();
    }

   /* private final static Comparator<IProduct> SORT_BY_PRODUCT_TYPE = new Comparator<IProduct>() {
        @Override
        public int compare(IProduct o1, IProduct o2) {
            //return o1.getProductName().compareToIgnoreCase(o2.getProductName());
            return o1.getProductType().getType().compareTo(o2.getProductType().getType());
        }
    };*/

    private final static Comparator<IProduct> SORT_BY_PRODUCT_TYPE =
            Comparator.comparing(IProduct::getProductType,
                    (t1, t2) -> {return t1.getType().compareTo(t2.getType());});

    //private final static Comparator<IProduct> SORT_BY_PRODUCT_TYPE2 =
    //(o1, o2) ->  o1.getProductType().getType().compareTo(o2.getProductType().getType());

    /*private final static Comparator<IProduct> SORT_BY_PRODUCT_TYPE2 = new Comparator<IProduct>() {
        @Override
        public int compare(IProduct o1, IProduct o2) {
            return (o1.getProductType().getType().compareTo(o2.getProductType().getType()));
        }
    };*/



    @Override
    public void sortProductsByProductType(){
        System.out.println("Πριν την ταξινόμηση");
        printProductList();

        myGenericIProductList.sort(ProductList.SORT_BY_PRODUCT_TYPE);

        // Με Collections.sort
        //Collections.sort(myGenericIProductList, SORT_BY_PRODUCT_TYPE);

        // Για descending με το product type
        //myGenericIProductList.sort(SORT_BY_PRODUCT_TYPE.reversed());

        System.out.println("Μετά την ταξινόμηση");
        printProductList();
    }

    @Override
    public void sortProductsByProductQuantity(){
        System.out.println("Πριν την ταξινόμηση");
        printProductList();

        myGenericIProductList.sort(new SortByProductQuantity());

        //Collections.sort(myGenericIProductList, new SortByProductQuantity());
        //myGenericIProductList.sort(new SortByProductQuantity().reversed());


        System.out.println("Μετά την ταξινόμηση");
        printProductList();

    }
}