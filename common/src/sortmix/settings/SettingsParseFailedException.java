package sortmix.settings;

/**
 * Exception class which is thrown when no port found
 *
 * @author Dariusz Opitek
 * @version 1.2
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
