package sortmix.program;

import java.io.IOException;
import sortmix.client.BadRequestException;
import sortmix.client.TCPClient;
import sortmix.consoleInterface.ConsoleUserInterface;
import sortmix.settings.SettingsParseFailedException;

/**
 * Main class of the application which gets user input and sends to server.
 * Result is presented to the user interface.
 *
 * @author Dariusz Opitek
 * @version 1.2
 */
public class Program {

    /**
     * Main method of the application
     * @param args command line arguments
     */
    public static void main(String[] args) {

        InputData inputValues = new ArgsParser().parse(args);
        ConsoleUserInterface userInterface = new ConsoleUserInterface();
        inputValues = userInterface.fillMissingData(inputValues);

        try{
            TCPClient client = new TCPClient();
            String result = client.start(inputValues);
            userInterface.present("Result: "+ result);
        }catch(SettingsParseFailedException | IOException | BadRequestException ex){
            userInterface.error(ex.getMessage());
        }
    }
}
