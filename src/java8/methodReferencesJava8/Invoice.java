package java8.methodReferencesJava8;

import java.math.BigDecimal;

class Invoice {

    String no;
    BigDecimal unitPrice;

    @Override
    public String toString() {
        return "Invoice{" +
                "no='" + no + '\'' +
                ", unitPrice=" + unitPrice +
                ", qty=" + qty +
                '}';
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Invoice(String no, BigDecimal unitPrice, Integer qty) {
        this.no = no;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    Integer qty;

    public Invoice(){

    }
    public Invoice(BigDecimal unitPrice) {
        this.unitPrice=unitPrice;
    }


}
