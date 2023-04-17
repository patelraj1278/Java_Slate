package quicktests;

/*
 * As a user that has an investment account, when you setup an account, you select which funds you would like to invest your money in. This set of funds along with the percent allocation and the balance is referred to as a portfolio.

 1. Given a portfolio and a target fund allocation, identify the orders that need to be placed to rebalance the portfolio to the desired state

 2. If any funds have to be sold, they must be sold before other funds are bought. Funds must be sold before other funds are bought since we need cash to buy subsequent fund

 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Portfolio is comprised of the balance(which is a dollar value) and currentFundAllocation
 */
class Portfolio
{
    List<FundAllocation> fundAllocations;
    Double balance;

    public List<FundAllocation> getFundAllocations()
    {
        return fundAllocations;
    }

    public Double getbalance()
    {
        return balance;
    }

    Portfolio(List<FundAllocation> fundAllocations, Double balance)
    {
        this.fundAllocations = fundAllocations;
        this.balance = balance;
    }
}

/**
 FundAllocation
 * fund - Captures the name of the fund
 * percent - Captures the percentage allocation for this fund
 */
class FundAllocation
{
    String fund;
    Double percent;

    public String getFund()
    {
        return fund;
    }

    public Double getPercent()
    {
        return percent;
    }

    FundAllocation(String fund, Double percent)
    {
        this.fund = fund;
        this.percent = percent;
    }
}

/**
 Order object can be used for the output of the method.
 * Captures the type of order buy or sell
 * Captures the name of the fund
 * captures the dollar value that must be bought or sold
 */
class Order
{
    String orderType;//Can be BUY or SELL
    String fund;
    Double amount;

    public String getOrderType()
    {
        return orderType;
    }

    public String getFund()
    {
        return fund;
    }

    public Double getAmount()
    {
        return amount;
    }

    public Order(String orderType, String fund, Double amount){
        this.orderType = orderType;
        this.amount = amount;
        this.fund = fund;
    }

    @Override public String toString(){
        return "OrderType=" + this.orderType + ":" + "Fund=" + this.fund + ":" + "Amount="
                + this.amount;
    }
}

class Solution
{
    static Double aggregator = Double.valueOf(0);
    public static void main(String[] args) throws Exception
    {
        FundAllocation portfolioFund1 = new FundAllocation("GOOG", 40.0);
        FundAllocation portfolioFund2 = new FundAllocation("AAPL", 60.0);
        List<FundAllocation> portfolioFundAllocations = List.of(portfolioFund1, portfolioFund2);
        Portfolio portfolio = new Portfolio(portfolioFundAllocations, 200.0);

        List<FundAllocation> targetAllocation1 = List.of(new FundAllocation("GOOG", 100.0));
        //Output -  [OrderType=SELL:Fund=AAPL:Amount=120.0, OrderType=BUY:Fund=GOOG:Amount=120.0]
        System.out.println(getOrdersNeededToRebalancePortfolio(portfolio, targetAllocation1));

        List<FundAllocation> targetAllocation2 = List.of(new FundAllocation("FB", 100.0));
        //Output -  [OrderType=SELL:Fund=GOOG:Amount=80.0, OrderType=SELL:Fund=AAPL:Amount=120.0 OrderType=BUY:Fund=FB:Amount=200.0]
        System.out.println(getOrdersNeededToRebalancePortfolio(portfolio, targetAllocation2));

        List<FundAllocation> targetAllocation3 = List.of(new FundAllocation("GOOG", 50.0),
                new FundAllocation("AAPL", 10.0), new FundAllocation("FB", 40.0));
        //Output -  [OrderType=SELL:Fund=AAPL:Amount=100.0, OrderType=BUY:Fund=GOOG:Amount=20.0 OrderType=BUY:Fund=FB:Amount=80.0]
        System.out.println(getOrdersNeededToRebalancePortfolio(portfolio, targetAllocation3));

        List<FundAllocation> targetAllocation4 = List.of(new FundAllocation("GOOG", 60.0),
                new FundAllocation("AAPL", 25.0), new FundAllocation("FB", 25.0));
        //Output -  throws Exception
        System.out.println(getOrdersNeededToRebalancePortfolio(portfolio, targetAllocation4));
    }

    private static Collection<Order> getOrdersNeededToRebalancePortfolio(Portfolio portfolio,
                                                                         List<FundAllocation> targetAllocation) throws Exception {
        List<Order> orders = new ArrayList<>();

        if(targetAllocation.stream().collect(Collectors.summingDouble(x->x.getPercent())) != 100){
            throw new RuntimeException("Allocation Exceeded");
        }else{
            targetAllocation.stream()
                .forEach(x->{
                    if(portfolio.getFundAllocations().stream().noneMatch(y->y.getFund().equalsIgnoreCase(x.getFund()))){
                        Order o = new Order("BUY", x.getFund() , x.getPercent() * portfolio.getbalance() * 0.01);
                        orders.add(o);
                    }
                });

            targetAllocation.stream().forEach(x-> {
                Double requiredAllocation = x.getPercent() * portfolio.getbalance() * 0.01;
                String requiredFund = x.getFund();
                //Current Portfolio
                portfolio.getFundAllocations().stream()
                        .forEach(y-> {
                            String portFundName = y.getFund();
                            Double portFund = y.getPercent() * portfolio.getbalance() * 0.01;
                            if(portFundName.equalsIgnoreCase(requiredFund)){
                                //Determine OrderType based on Positive or Negative value
                                if(requiredAllocation > portFund){
                                    //ORDERTYPE : BUY
                                    Double diff = requiredAllocation - portFund;
                                    Order o = new Order("BUY", portFundName , diff);
                                    orders.add(o);
                                }else if(requiredAllocation < portFund){
                                    //ORDERTYPE : SELL
                                    Double diff = portFund - requiredAllocation;
                                    Order o = new Order("SELL", portFundName , diff);
                                    orders.add(o);
                                }
                            }
                        });
                });

            orders.stream().forEach(x-> {
                if(x.getOrderType().equalsIgnoreCase("BUY")){
                    aggregator+= x.getAmount();
                }else if(x.getOrderType().equalsIgnoreCase("SELL")){
                    aggregator-= x.getAmount();
                }
            });

            portfolio.getFundAllocations().stream()
                    .forEach(x-> {
                        if(orders.stream().noneMatch(y->y.getFund().equalsIgnoreCase(x.getFund()))){
                            Double currentFundAmount = x.getPercent() * portfolio.getbalance() * 0.01;
                            if(currentFundAmount <= aggregator){
                                Order o = new Order("SELL", x.getFund() , currentFundAmount);
                                orders.add(o);
                            }
                        }
                    });
        }

        return orders;
    }
}