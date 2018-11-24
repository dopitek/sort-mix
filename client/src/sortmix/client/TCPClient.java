/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author dariu
 */
public class TCPClient {
    
    private Socket socket;
    
        /**
     * buffered input character stream
     */
    private BufferedReader input;
    /**
     * Formatted output character stream
     */
    private PrintWriter output;
    
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
    
    public String start(InputData values) throws IOException, BadRequestException{
        String answer = input.readLine();
        System.out.println(answer);
        
        SendMessage("TEXT " + values.getText());        
        SendMessage("MODE " + values.getSortingMode());
        answer = SendMessage("CALC");
        SendMessage("QUIT");
        return answer;
    }
    
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

