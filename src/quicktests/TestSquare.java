package quicktests;

import java.util.*;

public class TestSquare {

    public String injectMethod(String template, HashMap<String, String> input) {
        System.out.println("Current date time in milliseconds : "+new Date().getTime());
         for (Map.Entry<String, String> set :
                 input.entrySet()) {
                   template = template.replace("{"+set.getKey()+"}", set.getValue());
        }
        System.out.println("Current date time in milliseconds : "+new Date().getTime());
        return template;
    }

    public static void main(String[] args) {

        TestSquare s = new TestSquare();

        HashMap<String, String> input = new HashMap<>();
        input.put("name", "Ryan");
        input.put("age", "35");
        input.put("miles", "50000");

        System.out.println(s.injectMethod("Hi, my name is {name} and I am {age} years old", input));
        //System.out.println(s.injectMethod("My car has {miles} miles on it", input)); // My car has 50,000 miles on it

    }


}


//template =template.replace("{name}", input.get("name"));
//template= template.replace("{age}", input.get("age"));

//Iterate Hashmap keys & parse String & if any match found then feed Key's Value.
/*input.forEach(
                (key, value) -> {
                    //{System.out.println(key + " = " + value);
                    template.replace(key, value);
                });*/

    /* Printing all elements of a Map
                /*System.out.println(set.getKey() + " = "
                                   + set.getValue());*/

    /*System.out.println(
            s.injectMethod("Hi, my name is {name} and I am {age} years old", input) == "Hi, my name is Ryan and I am 35 years old".toString()
        ); // false

        System.out.println(
                s.injectMethod("Hi, my name is {name} and I am {age} years old", input).equalsIgnoreCase("Hi, my name is Ryan and I am 35 years old".toString()
                )); // true*/

    /*if(sb.toString().equalsIgnoreCase("{"+set.getKey()+"}")){

    }*/

     /*for (Map.Entry<String, String> set :
                 input.entrySet()) {
                   template = template.replace("{"+set.getKey()+"}", set.getValue());
        }*/

    /*
    char[] tempChar = template.toCharArray();
        for(char i=0 ; i< tempChar.length;i++){
            if(String.valueOf(tempChar[i]).equalsIgnoreCase("{")){
                List<Character> chars = new ArrayList<>();
                while(!String.valueOf(tempChar[i+1]).equalsIgnoreCase("}")){
                    chars.add(tempChar[i+1]);
                    i++;
                }
                StringBuilder sb = new StringBuilder();
                for (Character ch : chars) {
                    sb.append(ch);
                }
                for (Map.Entry<String, String> set :
                        input.entrySet()) {
                    if(sb.toString().equalsIgnoreCase(set.getKey())){
                        System.out.println("Found");
                    }
                }
            }
        }
     */
