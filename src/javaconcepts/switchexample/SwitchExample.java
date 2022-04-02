package javaconcepts.switchexample;

public class SwitchExample {
    public static void tradingOptionChooser(String trading) {
        switch (trading) {
            case "Stock Trading":
                System.out.println("Trader has selected Stock Trading option");
                break;
            case "Electronic Trading":
                System.out.println("Trader has selected Electronic Trading option");
                break;
            case "Algorithmic Trading":
                System.out.println("Trader has selected Algorithmic Trading option");
                break;
            case "Foreign exchange trading":
                System.out.println("Trader has selected Foreign exchange Trading option");
                break;
            case "commodity trading":
                System.out.println("Trader has selected commodity trading option");
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static void main(String [] args){
        SwitchExample.tradingOptionChooser("Stock Trading");
    }
}
