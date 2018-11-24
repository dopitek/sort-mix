/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmix.settings;

/**
 *
 * @author dariu
 */
public class SettingsParseFailedException extends Exception{
    
    /**
     * Empty constructor
     */
    public SettingsParseFailedException() {
    }

    /**
     * Constructor with message
     *
     * @param message display message
     */
    public SettingsParseFailedException(String message) {
        super(message);
    }
}
