package java8;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Java8StringJoiner {

    //1. StringJoiner
    public void java8StringJoiner(){
        //1.1 Join String by a delimiter
        StringJoiner sj = new StringJoiner(",");
        sj.add("aaa");
        sj.add("bbb");
        sj.add("ccc");
        String result = sj.toString(); //aaa,bbb,ccc
        System.out.println(result);


        //1.2 Join String by a delimiter and starting with a supplied prefix and ending with a supplied suffix.
        StringJoiner sj1 = new StringJoiner("/", "prefix-", "-suffix");
        sj1.add("2016");
        sj1.add("02");
        sj1.add("26");
        String result1 = sj1.toString(); //prefix-2016/02/26-suffix
        System.out.println(result1);
    }


    //2. String.join
    public void java8StringJoiner1(){
        //2.1 Join String by a delimiter.
        String result = String.join("-", "2015", "10", "31" );
        System.out.println(result);

        //2.2 Join a List by a delimiter.
        List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
        //java, python, nodejs, ruby
        String result1 = String.join(", ", list);
        System.out.println(result1);
    }

    //3. Collectors.joining
    //Two Stream and Collectors.joining examples.
    public void java8StringJoiner3(){

        //3.1 Join List<String> example.
        List<String> list = Arrays.asList("java", "python", "nodejs", "ruby");
        //java | python | nodejs | ruby
        String result = list.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(" | "));
        System.out.println(result);

        //3.2 Join List<Object> example.
        List<Game> list1 = Arrays.asList(
                new Game("Dragon Blaze", 5),
                new Game("Angry Bird", 5),
                new Game("Candy Crush", 5)
        );

        //{Dragon Blaze, Angry Bird, Candy Crush}
        String result1 = list1.stream().map(x -> x.getName())
                .collect(Collectors.joining(", ", "{", "}"));
        System.out.println(result1);
    }


    public static void main(String[] args) {
        Java8StringJoiner js = new Java8StringJoiner();
        js.java8StringJoiner();
        js.java8StringJoiner1();
        js.java8StringJoiner3();
    }

}

class Game{
    String name;
    int ranking;

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", ranking=" + ranking +
                '}';
    }

    public Game(String name, int ranking) {
        this.name = name;
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }
}
