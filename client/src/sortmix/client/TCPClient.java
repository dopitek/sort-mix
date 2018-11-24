package sortmix.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import sortmix.program.InputData;
import sortmix.settings.Settings;
import sortmix.settings.SettingsParseFailedException;
import sortmix.settings.SettingsParser;

/**
 * Class for handling communication with Server
 *
 * @author Dariusz Opitek
 * @version 1.2
 */
public class TCPClient {
    
    /**
     * field represents the socket which connects to the server
     */
    private Socket socket;
    
    /**
     * buffered input character stream
     */
    private BufferedReader input;
    
    /**
     * formatted output character stream
     */
    private PrintWriter output;
    
    /**
     * Default constructor
     * @throws IOException
     * @throws SettingsParseFailedException
     */
    public TCPClient() throws IOException, SettingsParseFailedException{
        SettingsParser parser = new SettingsParser();
        Settings settings = parser.parse("settings.properties");
        
        if (settings == null)
            throw new SettingsParseFailedException();
        
        this.socket = new Socket("localhost", settings.getPort());
        
        this.input =
            new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.output = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                socket.getOutputStream())), true);
    }
    
    /**
     * Method which sends all values to the server and waits for answer
     * @param values values to be sent
     * @return returns final server answer
     * @throws IOException
     * @throws BadRequestException
     */
    public String start(InputData values) throws IOException, BadRequestException{
        String answer = input.readLine();
        
        SendMessage("TEXT " + values.getText());   
        SendMessage("MODE " + values.getSortingMode());
        answer = SendMessage("CALC");
        SendMessage("QUIT");
        return answer;
    }
    
    /**
     * Method which sends single message to the server and waits for answer
     * @param message message to be sent
     * @return returns server answer
     * @throws IOException
     * @throws BadRequestException
     */
    private String SendMessage(String message) throws IOException, BadRequestException
    {
        this.output.println(message);
        
        if (message.equals("QUIT"))
            return "Disconnected";
        
        String answer = input.readLine();
        if (!answer.substring(0, 3).equals("200"))
            throw new BadRequestException(answer);
            
        return answer.substring(4, answer.length());
    }
}

