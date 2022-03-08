package gr.aueb.elearn.chap13.supermarket;

public interface IProduct {
    IBarCode getProductBarCode();
    String getProductName();
    int getQuantity();
    ProductType getProductType();
    double getProductPrice();
}
