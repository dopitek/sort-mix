package sortmix.server;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import sortmix.model.TextSorterModel;
import sortmix.settings.Settings;
import sortmix.settings.SettingsParseFailedException;
import sortmix.settings.SettingsParser;

/**
 * The main class of the server
 *
 * @author Gall Anonim
 * @version 1.2
 */
public class TCPServer implements Closeable {

    /**
     * port number
     */
    private int port;

    /**
     * field represents the socket waiting for client connections
     */
    private ServerSocket serverSocket;
    
    
    private TextSorterModel model;

    /**
     * Creates the server socket
     *
     * @throws sortmix.settings.SettingsParseFailedException
     * @throws IOException when prot is already bind
     */
    public TCPServer() throws SettingsParseFailedException, IOException {
        //this.port = port;
        this.model = new TextSorterModel();
        SettingsParser parser = new SettingsParser();
        Settings settings = parser.parse("settings.properties");
        
        if (settings == null)
            throw new SettingsParseFailedException();
        
        serverSocket = new ServerSocket(settings.getPort());
    }

    public void start() {
        try {
            System.out.println("Server started");
            while (true) {
                Socket socket = this.serverSocket.accept();
                try (SingleService singleService = new SingleService(socket, this.model)) {
                    singleService.realize();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void close() throws IOException {
        if (serverSocket != null) {
            serverSocket.close();
        }
    }
}
