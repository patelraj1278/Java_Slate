package java8.functionalInterfaceJava8;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Java8BiConsumer {

    public void biConsumer1(){
        BiConsumer<Integer,Integer> addTwo = (x, y) -> System.out.println(x + y);
        addTwo.accept(1, 2);    // 3
    }


    //2.1 This example accepts BiConsumer as an argument, create a generic addTwo to join two objects.
    public void biConsumer2(){
        addTwo(1, 2, (x, y) -> System.out.println(x + y));          // 3
        addTwo("Node", ".js", (x, y) -> System.out.println(x + y)); // Node.js
    }

    //Takes two Integer & return Integer by doing math operation
    public void biConsumer3() {
        math(1, 1, (x, y) -> System.out.println(x + y));   // 2
        math(1, 1, (x, y) -> System.out.println(x - y));   // 0
        math(1, 1, (x, y) -> System.out.println(x * y));   // 1
        math(1, 1, (x, y) -> System.out.println(x / y));   // 1
    }

    //In the JDK source code, Map.forEach accepts a BiConsumer as an argument.
    public void biConsumer4() {
        Map<Integer, String> map = new LinkedHashMap<>();

        map.put(1, "Java");
        map.put(2, "C++");
        map.put(3, "Rust");
        map.put(4, "JavaScript");
        map.put(5, "Go");

        map.forEach((k, v) -> System.out.println(k + ":" + v));

        /* forEach internal does below where it pass BiConsumer as parameter.
        Map.java

            default void forEach(BiConsumer<? super K, ? super V> action) {
                    Objects.requireNonNull(action);
                    for (Map.Entry<K, V> entry : entrySet()) {
                        K k;
                        V v;
                        try {
                            k = entry.getKey();
                            v = entry.getValue();
                        } catch (IllegalStateException ise) {
                            // this usually means the entry is no longer in the map.
                            throw new ConcurrentModificationException(ise);
                        }
                        action.accept(k, v);
                    }
                }
         */
    }

    public static void main(String[] args) {
        Java8BiConsumer biC = new Java8BiConsumer();
        biC.biConsumer1();
        biC.biConsumer2();
        biC.biConsumer3();
        biC.biConsumer4();
    }

    static <T> void addTwo(T a1, T a2, BiConsumer<T,T> c){
        c.accept(a1,a2);
    }

    static <Integer> void math(Integer a1, Integer a2, BiConsumer<Integer, Integer> c) {
        c.accept(a1, a2);
    }
}
