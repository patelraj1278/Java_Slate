package javaconcepts.encapsulation;

/*

Many design pattern in Java uses the encapsulation concept, one of them is Factory pattern which is used to create objects.
A factory pattern is a better choice than a new operator for creating an object of those classes whose creation logic can vary and also for creating different implementations of the same interface.

 */
class Loan{
    private int duration;  //private variables examples of encapsulation
    private String loan;
    private String borrower;
    private String salary;

    //public constructor can break encapsulation instead use factory method
    private Loan(int duration, String loan, String borrower, String salary){
        this.duration = duration;
        this.loan = loan;
        this.borrower = borrower;
        this.salary = salary;
    }

    //no argument constructor omitted here

    // create loan can encapsulate loan creation logic
    public Loan createLoan(String loanType){

        //processing based on loan type and then returning loan object
        return new Loan(10,"checking","RJ","100");
    }

}