package quicktests;

import java.util.ArrayList;
import java.util.List;

public class Identrust {

    public Integer getInteger(Integer i, List<String> list){
        Integer number  = i++;
        list.add("abc");
        list.add("def");
        list.add("aerg");
        i = list.size();
        System.out.println("Before count"+i);
        i++;
        System.out.println("After count"+i);
        return number;
    }
    public static void main(String [] arg){
        Identrust it = new Identrust();
        Identrust it1 = new Identrust();
        Identrust it2 = new Identrust();
        it1 = it2;
        List<String> strList= new ArrayList<>();
        Integer i = 0;
        Integer returned = it.getInteger(i,strList);
        System.out.println("Result=>"+(returned==i));
    }
}
