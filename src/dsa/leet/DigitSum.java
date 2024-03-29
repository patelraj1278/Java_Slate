package dsa.leet;

public class DigitSum {
    public static int alternateDigitSum(int n) {
        int firstHalf = 0;
        int secondHalf = 0;
        int count = 0;
        while (n > 0) {
            secondHalf += n % 10;
            n /= 10;
            count++;
            if (n > 0) {
                firstHalf += n % 10;
                n /= 10;
                count++;
            }
        }
        return count % 2 == 0 ? (firstHalf + -1 * secondHalf) : (secondHalf + -1 * firstHalf);
    }

    public static void main(String [] args){
        System.out.println(alternateDigitSum(5));
    }
}
