package javaconcepts.polymorphism;

public class TradingSystem{
    public String getDescription(){
        return "electronic trading system";
    }
}

class DirectMarketAccessSystem extends TradingSystem{
    public String getDescription(){
        return "direct market access system";
    }
}

class CommodityTradingSystem extends TradingSystem{
    public String getDescription(){
        return "Futures trading system";
    }
}