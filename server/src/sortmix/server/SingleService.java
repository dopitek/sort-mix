package sortmix.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import sortmix.common.SortingMode;
import sortmix.model.NoTextInputException;
import sortmix.model.NonSortingModeException;
import sortmix.model.TextSorterModel;

/**
 * The server class servicing a single connection
 * @author Dariusz Opitek
 * @version 1.2
 */
class SingleService implements Closeable {

    /**
     * socket representing connection to the client
     */
    private Socket socket;
    /**
     * buffered input character stream
     */
    private BufferedReader input;
    /**
     * Formatted output character stream
     */
    private PrintWriter output;
    /**
     * Model used to store and process input data
     */
    private TextSorterModel model;

    /**
     * The constructor of instance of the SingleService class. Use the socket as
     * a parameter.
     *
     * @param socket socket representing connection to the client     
     * @param model model used to store and process data
     */
    public SingleService(Socket socket, TextSorterModel model) throws IOException {
        this.socket = socket;
        this.model = model;
        output = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream())), true);
        input = new BufferedReader(
                new InputStreamReader(
                        socket.getInputStream()));
    }

    /**
     * Realizes the service
     */
    public void realize() {
        try {
            output.println("Welcome to Java Sever");

            while (true) {
                String str = input.readLine();

                if (str.length() < 4) {
                    output.println("400 Bad request - see HELP for more information");
                    continue;
                }

                String command = str.substring(0, 4);
                String value = "";

                if (str.toUpperCase().equals("QUIT")) {
                    break;
                }

                switch (command) {
                    case "TEXT":
                        value = str.substring(5, str.length());
                        if (value.length() != 0) {
                            model.setText(value);
                            output.println("200 Text set");
                        } else {
                            output.println("400 Text not found");
                        }
                        break;
                    case "MODE":
                        value = str.substring(5, str.length());
                        if (value.length() != 0) {
                            if (value.equals("m")) {
                                model.setSortingMode(SortingMode.Mix);
                            } else if (value.equals("s")) {
                                model.setSortingMode(SortingMode.Sort);
                            } else {
                                output.println("400 Wrong sorting mode");
                                break;
                            }
                            output.println("200 Mode set");
                        } else {
                            output.println("400 Mode not found");
                        }
                        break;
                    case "CALC":
                        try {
                            String result = model.process();
                            output.println("200 " + result);
                        } catch (NonSortingModeException | NoTextInputException ex) {
                            output.println("500 " + ex.getMessage());
                        }
                        break;
                    case "HELP":
                        output.println("200 Accepted requests: TEXT <text> - sets text to be analyzed, MODE <sortingmode> - s for Sort and m for mix, CALC - process result");
                        break;
                    default:
                        output.println("400 Wrong request");
                }

                System.out.println("Client sent: " + str);
            }
            System.out.println("closing...");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void close() throws IOException {
        if (socket != null) {
            socket.close();
        }
    }
}
