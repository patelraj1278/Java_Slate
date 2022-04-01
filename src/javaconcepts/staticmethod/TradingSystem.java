package javaconcepts.staticmethod;

public class TradingSystem {
    public static void main(String[] args) {
        TradingSystem system = new DirectMarketAccess();
        DirectMarketAccess dma = new DirectMarketAccess();

        // static method of Instrument class will be called,
        // even though object is of sub-class DirectMarketAccess
        system.printCategory();

        //static method of EquityInstrument class will be called
        dma.printCategory();
    }

    public static void printCategory(){
        System.out.println("inside super class static method");
    }
}

class DirectMarketAccess extends TradingSystem{
    public static void printCategory(){
        System.out.println("inside sub class static method");
    }
}
