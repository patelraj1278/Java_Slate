package java8.lambdaComparatorJava8;

import java.math.BigDecimal;

public class Developer {

    public Developer(String name, BigDecimal no, int no1) {
        this.name = name;
        this.no = no;
        this.no1 = no1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getNo() {
        return no;
    }

    public void setNo(BigDecimal no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                ", no=" + no +
                ", no1=" + no1 +
                '}';
    }

    public int getNo1() {
        return no1;
    }

    public void setNo1(int no1) {
        this.no1 = no1;
    }

    private String name;
    private BigDecimal no;
    private int no1;

}
