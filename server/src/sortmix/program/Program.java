package sortmix.program;

import sortmix.settings.SettingsParseFailedException;
import java.io.IOException;
import sortmix.server.TCPServer;

/**
 * Main class of the server which starts the TCPServer
 *
 * @author Dariusz Opitek
 * @version 1.2
 */
public class Program {

    /**
     * Main method of the application which starts the TCPServer
     *
     * @param args command line arguments not used
     */
    public static void main(String[] args) {

        try {
            TCPServer server = new TCPServer();
            server.start();
        } catch (SettingsParseFailedException | IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
