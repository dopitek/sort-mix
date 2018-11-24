package sortmix.program;

import sortmix.settings.SettingsParseFailedException;
import java.io.IOException;
import sortmix.server.TCPServer;

/**
 * Main class of the application which sorts or mixes content of given text.
 * Result is presented to the user interface.
 *
 * @author Dariusz Opitek
 * @version 1.1
 */
public class Program {

    /**
     * Main method of the application Arguments should contain following
     * arguments: -t "text_to_be_analyzed" -s or -m - for sort or mix
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        try {
            TCPServer server = new TCPServer();
            server.start();
            //while (true);

        } catch (SettingsParseFailedException | IOException ex) {

        }

        

    }
}
