package dsa.leet;

public class AddDigit {
    public static int addDigits(int num) {
        if (num / 10 == 0) {
            return num;
        }
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
        }
        return addDigits(digitSum);
    }
    public static void main(String [] args){
        addDigits(5);
    }
}
