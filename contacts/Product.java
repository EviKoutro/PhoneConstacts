package gr.aueb.elearn.chap13.supermarket;

import org.jetbrains.annotations.NotNull;
import java.io.Serializable;

public class Product implements IProduct, Serializable, Comparable<Product> {
    private static final long serialVersionUID = 1L;

    private ProductType productType;
    private String productName;
    private double productPrice;
    private IBarCode productBarCode;
    private int quantity;

    public Product() {}

    public Product(ProductType productType, String productName, double productPrice, IBarCode productBarCode, int quantity) {
        this.productType = productType;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productBarCode = productBarCode;
        this.quantity = quantity;
    }

    @Override
    public String getProductName() {
        return productName;
    }
    @Override
    public IBarCode getProductBarCode() {
        return productBarCode;
    }
    @Override
    public ProductType getProductType() {
        return productType;
    }
    public void setProductType(ProductType productType) {
        this.productType = productType;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    @Override
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    public void setProductBarCode(IBarCode productBarCode) {
        this.productBarCode = productBarCode;
    }
    @Override
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.getProductPrice(), getProductPrice()) == 0 &&
                getQuantity() == product.getQuantity() &&
                getProductType() == product.getProductType() &&
                getProductName().equals(product.getProductName()) &&
                getProductBarCode().decodeCode().equals(product.getProductBarCode().decodeCode());
    }

    @Override
    public int hashCode() {
        //return Objects.hash(getProductType(), getProductName(), getProductPrice(), getProductBarCode(), getQuantity());

        final int prime = 31;
        int result = 1;
        result = prime * result + getQuantity() + (int)Math.round(getProductPrice());
        result = prime * result + ((getProductType() == null ) ? 0 : getProductType().hashCode());
        result = prime * result + ((getProductName() == null ) ? 0 : getProductName().hashCode());
        result = prime * result + ((getProductBarCode().decodeCode() == null ) ? 0 : getProductBarCode().decodeCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productType=" + productType +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productBarCode=" + productBarCode.decodeCode() +
                ", quantity=" + quantity +
                '}';
    }
/*
    @Override
    public int compareTo(@NotNull Product o){
        if (this.getProductPrice() < o.getProductPrice() ) return -1;
        else if (this.getProductPrice() == o.getProductPrice()) return 0;
        else return 1;
    }

    @Override
    public int compareTo(@NotNull Product o){
        return (this.getQuantity() - o.getQuantity());
    }
*/
    @Override
    public int compareTo(@NotNull Product o){
        return (this.getProductName().compareTo(o.getProductName()));
    }
}
