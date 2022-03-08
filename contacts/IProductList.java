package gr.aueb.elearn.chap13.supermarket;

public interface IProductList {
    boolean addNewProduct(IProduct product);
    boolean updateProduct(IProduct oldProduct, IProduct newProduct);
    boolean removeProduct(IProduct product);
    IProduct getProductByBarCode(IBarCode barCode);
    IProduct getProductByName(String productName);
    boolean productCodeExists(IBarCode barCode);
    void printProductList();
    void sortByProductName();
    void sortProductsByProductPrice();
    void sortProductsByProductType();
    void sortProductsByProductQuantity();
}
