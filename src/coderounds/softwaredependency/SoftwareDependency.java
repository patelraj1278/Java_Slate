package coderounds.softwaredependency;

public class SoftwareDependency {

    enum COMMAND {
        DEPEND,
        INSTALL,
        REMOVE,
        LIST,
        END
    }

    static void doIt(String[] input) {
        for (String inp : input) {
            System.out.println(inp);
            final String[] commandTokens = inp.split("\\s+");

            final String commandString = commandTokens[0];
            final COMMAND command = COMMAND.valueOf(commandString);

            switch (command) {
                case DEPEND:
                    break;
                case INSTALL:
                    break;
                case REMOVE:
                    break;
                case LIST:
                    break;
                case END:
                    break;
            }
        }
    }

    public static void main(String [] args){
        String[] inp = new String[]{"DEPEND TELNET TCPIP NETCARD",
                "DEPEND TCPIP NETCARD",
                "DEPEND NETCARD TCPIP",
                "DEPEND DNS TCPIP NETCARD",
                "DEPEND BROWSER TCPIP HTML",
                "INSTALL NETCARD",
                "INSTALL TELNET",
                "INSTALL foo",
                "REMOVE NETCARD",
                "INSTALL BROWSER",
                "INSTALL DNS",
                "LIST",
                "REMOVE TELNET",
                "REMOVE NETCARD",
                "REMOVE DNS",
                "REMOVE NETCARD",
                "INSTALL NETCARD",
                "REMOVE TCPIP",
                "REMOVE BROWSER",
                "REMOVE TCPIP",
                "LIST",
                "END"};

        doIt(inp);
    }
}
