package gr.aueb.elearn.chap13.supermarket;

import java.io.Serializable;
//import java.util.Objects;

public class BarCode implements IBarCode, Serializable {
    private final String barCode;

    @Override
    public String decodeCode(){
        return getBarCode();
    }

    public BarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getBarCode() {
        return barCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BarCode)) return false;
        BarCode barCode1 = (BarCode) o;
        return getBarCode().equals(barCode1.getBarCode());
    }

    @Override
    public int hashCode() {
        //return Objects.hash(getBarCode());
        final int prime = 31;
        int result = 1;

        result = prime * result + ( (barCode == null) ? 0 : barCode.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "BarCode{" +
                "barCode='" + barCode + '\'' +
                '}';
    }
}
