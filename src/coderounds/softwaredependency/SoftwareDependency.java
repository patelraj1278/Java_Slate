package coderounds.softwaredependency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SoftwareDependency {

    enum COMMAND {
        DEPEND,
        INSTALL,
        REMOVE,
        LIST,
        END;
    }

    private static Map<String, List<String>> allSoftware = new HashMap<>();

    static void doIt(String[] input) {
        for (String inp : input) {
            System.out.println(inp);
            final String[] commandTokens = inp.split("\\s+");

            final String commandString = commandTokens[0];
            final COMMAND command = COMMAND.valueOf(commandString);

            switch (command) {
                case DEPEND:
                    final String softwareName = commandTokens[1];
                    buildDependencies(softwareName, commandTokens);
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

    private static void buildDependencies(String softwareName, String[] commandTokens) {
        //The dependencies of the current command are available from 3rd position onwards
        for (int i = 2; i < commandTokens.length; i++) {
            final String currentDependency = commandTokens[i];
            List<String>  checkDependenciesOfdependency = allSoftware.get(softwareName);
            if(checkDependenciesOfdependency != null && checkDependenciesOfdependency.contains(softwareName)){
                    System.out.println(
                        currentDependency + " depends on " + softwareName + ", ignoring command");
            }else{
                List<String>  dependenciesOfdependency = new ArrayList<>();
                dependenciesOfdependency.add(softwareName);
                allSoftware.put(softwareName,dependenciesOfdependency);
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
