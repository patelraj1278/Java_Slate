package javaconcepts.patternmatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherExample {

    public void pattern_1(String input){
        String regex = "\\b(\\w+)(\\s+\\1\\b)*";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);

        // Check for subsequences of input that match the compiled pattern
        while (m.find()) {
            input = input.replaceAll(m.group(0), m.group(1));
        }

        System.out.println(input);
    }

    public static void main(String [] args){
        PatternMatcherExample pm = new PatternMatcherExample();
        pm.pattern_1("Goodbye bye bye world world world\n" +
                "Sam went went to to to his business\n" +
                "Reya is is the the best player in eye eye game\n" +
                "in inthe\n" +
                "Hello hello Ab aB");

        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun32"));//true
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "kkvarun32"));//false (more than 6 char)
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "JA2Uk2"));//true
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun$2"));//false ($ is not matched)
    }
}
