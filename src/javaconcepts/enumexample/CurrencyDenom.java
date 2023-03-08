package javaconcepts.enumexample;

import java.util.Arrays;

public enum CurrencyDenom {

    PENNY(1) {
        @Override
        public String color() {
            return "copper";
        }
    },
    NICKLE(5) {
        @Override
        public String color() {
            return "bronze";
        }
    },
    DIME(10) {
        @Override
        public String color() {
            return "silver";
        }
    },
    QUARTER(25) {
        @Override
        public String color() {
            return "silver";
        }
    };

    private int value;
    public abstract String color();

    private CurrencyDenom(int value) {
        this.value = value;
    }

    public static void main(String args[]){
        System.out.println(CurrencyDenom.valueOf("QUARTER"));
        System.out.println(CurrencyDenom.QUARTER.color());
        System.out.println(CurrencyDenom.PENNY.ordinal());
        System.out.println(CurrencyDenom.QUARTER);
        Arrays.stream(CurrencyDenom.values()).forEach(System.out::println);

    }

}



//isBETWEEN method returns true or false if our passing month is between our start & end month

enum MONTH{
    JAN(31),
    FEB(29),
    MAR(31),
    APR(30),
    MAY(31),
    JUN(30),
    JUL(31),
    AUG(31),
    SEP(30),
    OCT(31),
    NOV(30),
    DEC(31),
    ;

    private int maxDays;
    private MONTH start;
    private MONTH end;
    private MONTH(int maxDays)
    {
        this.maxDays=maxDays;
    }
    public int getmaxDays()
    {
        return maxDays;
    }
    public boolean isBetween (MONTH start,MONTH end) {
        return (end.ordinal() > start.ordinal()) ? ((this.ordinal() >= start.ordinal()) && (this.ordinal() <= end.ordinal())) : ((this.ordinal() >= start.ordinal()) || (this.ordinal() <=end.ordinal()));
    }

}

//returns season name for which our passed month belongs

enum Season {

    SUMMER (MONTH.APR,MONTH.JUN),
    MONSOON (MONTH.JUL,MONTH.SEP),
    AUTUM(MONTH.OCT,MONTH.NOV),
    WINTER(MONTH.DEC,MONTH.JAN),
    SPRING(MONTH.FEB,MONTH.MAR),
    ;

    private MONTH startmonth;
    private MONTH endmonth;

    Season(MONTH start,MONTH end)
    {
        this.startmonth=start;
        this.endmonth=end;
    }

    private MONTH getstartm ()
    {
        return this.startmonth;
    }

    private MONTH getendm ()
    {
        return this.endmonth;
    }

    static  Season getSeason (MONTH m) {
        Season [] allseason = Season.values();
        for (Season s : allseason) {
            if (m.isBetween (s.startmonth,s.endmonth))
            {
                return s;
            }
        }
        return null;
    }

}

//abstract ENUM class which perform different implementation (eg. of polymorphism)

class Enumexamples {
    public static void main(String [] args) {

        MONTH m= MONTH.valueOf("MAR"); //we are checking that whether MAR is between our start & end month?
        System.out.println(m);
        int p=m.ordinal();
        System.out.println(p);
        System.out.println("IS BETWEEN :" +m.isBetween(MONTH.DEC,MONTH.FEB)); //passing start & end month is DEC & FEB

        Season s = Season.getSeason(MONTH.DEC);
        System.out.println("SEASON NAME :"+s);


    }
}

enum Arithmaticoperator {
    ADD {
        public double calculate (double a,double b)
        {
            return a+b;
        }
    },
    SUB {
        public double calculate (double a,double b)
        {
            return a-b;
        }
    },
    DIV {
        public double calculate (double a,double b)
        {
            return a/b;
        }
    },
    ;

    abstract double calculate (double a,double b);

}

class abstractenum {
    public static void main(String [] args) {
        Arithmaticoperator op1= Arithmaticoperator.valueOf(args[0]);
        double s=op1.calculate (2,3);
        System.out.println("FINAL :" +s);
    }
}


enum FindMonths {

    JAN(31),
    FEB(29),
    MAR(31),
    APR(30),
    MAY(31),
    JUN(30),
    JUL(31),
    AUG(31),
    SEP(30),
    OCT(31),
    NOV(30),
    DEC(31),
    ;

    private int days;
    FindMonths(int days){
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public boolean isBetween (MONTH start,MONTH end) {
        return (end.ordinal() > start.ordinal()) ? ((this.ordinal() >= start.ordinal()) && (this.ordinal() <= end.ordinal())) : ((this.ordinal() >= start.ordinal()) || (this.ordinal() <=end.ordinal()));
    }

    public static void main(String [] args) {

        MONTH m= MONTH.valueOf("MAR");
        System.out.println(m);
        int p = m.ordinal(); //Returns the ordinal of this enumeration constant (its position in its enum declaration, where the initial constant is assigned an ordinal of zero
        System.out.println(p);

        String name = m.name(); //Returns the name of this enum constant, exactly as declared in its enum declaration.
        System.out.println(name);

        int max = m.getmaxDays(); //Way to get assigned value through constructor & getter method
        System.out.println(max);

        boolean result = m.isBetween(MONTH.JAN,MONTH.APR); //enum logical operation
        System.out.println(result);
    }
}

enum SwtichCaseEnumExample{
    PENNY(1) {
        @Override public String color() {
            return "copper";
        }
    },
    NICKLE(5) {
        @Override public String color() {
            return "bronze";
        }
    },
    DIME(10) {
        @Override public String color() {
            return "silver";
        }
    },
    QUARTER(25) {
        @Override public String color() {
            return "silver";
        }
    };



    @Override
    public String toString() {
        return "SwtichCaseEnumExample{" +
                "value=" + value +
                '}';
    }

    private int value;
    private SwtichCaseEnumExample(int value) {
        this.value = value;
    }

    public abstract String color();

    public void getSwtichCaseEnumExample(SwtichCaseEnumExample usCoin){

        for(SwtichCaseEnumExample coin: SwtichCaseEnumExample.values()){
            System.out.println("coin: " + coin);
        }

        switch (usCoin) {
            case PENNY:
                System.out.println("Penny coin");
                break;
            case NICKLE:
                System.out.println("Nickle coin");
                break;
            case DIME:
                System.out.println("Dime coin");
                break;
            case QUARTER:
                System.out.println("Quarter coin");
        }
    }

    public static void main(String [] args) {
        SwtichCaseEnumExample sc = SwtichCaseEnumExample.DIME;
        sc.getSwtichCaseEnumExample(sc);
        System.out.println(SwtichCaseEnumExample.PENNY.color());
    }
}

    /**
     * Java Program to parse String to Enum in Java with examples.
     */

enum LOAN {
    HOME_LOAN {
        @Override
        public String toString() {
            return "Always look for cheaper Home loan";

        }
    },
    AUTO_LOAN {
        @Override
        public String toString() {
            return "Cheaper Auto Loan is better";
        }
    },
    PEROSNAL_LOAN{
        @Override
        public String toString() {
            return "Personal loan is not cheaper any more";
        }
    };

    public static void main(String[] args) {

        // Java example to convert Enum to String in Java
        String homeLoan = LOAN.HOME_LOAN.name();
        System.out.println(homeLoan);

        String autoLoan = LOAN.AUTO_LOAN.name();
        System.out.println(autoLoan);

        String personalLoan = LOAN.PEROSNAL_LOAN.name();
        System.out.println(personalLoan);


        // Exmaple of Converting String to Enum in Java
        LOAN homeLoan1 = LOAN.valueOf("HOME_LOAN");
        System.out.println(homeLoan1);

        LOAN autoLoan1 = LOAN.valueOf("AUTO_LOAN");
        System.out.println(autoLoan1);

        LOAN personalLoan1 = LOAN.valueOf("PEROSNAL_LOAN");
        System.out.println(personalLoan1);
    }
}




