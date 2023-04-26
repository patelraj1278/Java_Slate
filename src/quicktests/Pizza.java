package quicktests;

import java.util.Collections;

public final class Pizza {

    private final String name;
    private final String crust_type;
    private final String sauce_type;

    public Pizza(String name, String crust_type, String sauce_type) {
        this.name = name;
        this.crust_type = crust_type;
        this.sauce_type = sauce_type;
    }

    public String getName() {
        return name;
    }

    public String getCrust_type() {
        return crust_type;
    }

    public String getSauce_type() {
        return sauce_type;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "name='" + name + '\'' +
                ", crust_type='" + crust_type + '\'' +
                ", sauce_type='" + sauce_type + '\'' +
                '}';
    }

    public static void main(String [] args){
        Pizza pizza = new Pizza("abc","xyz","123");
        System.out.println(pizza);
    }

}
