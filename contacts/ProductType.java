package gr.aueb.elearn.chap13.supermarket;

import org.jetbrains.annotations.NotNull;

public enum ProductType {
    MILK("MILK"),
    HONEY("HONEY"),
    CHEESE("CHEESE"),
    BEANS("BEANS")
    ;

    private final String type;

    ProductType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "type='" + type + '\'' +
                '}';
    }
}
