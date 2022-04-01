package javaconcepts.finalkeyword;

public class PersonalLoan {
    public static final String LOAN = "loan";


    public static void main(String [] args){
        //LOAN = new String("loan"); //invalid compilation error
    }



    public final String getName(){
        return "personal loan";
    }
}

class CheapPersonalLoan extends PersonalLoan{
    /*@Override
    public final String getName(){
        return "cheap personal loan"; //compilation error: overridden method is final
    }*/
}


final class PersonalLoanFinal{

}

/*
class CheapPersonalLoan extends PersonalLoanFinal{  //compilation error: cannot inherit from final class

}*/
