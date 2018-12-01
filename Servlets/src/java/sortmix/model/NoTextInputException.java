package sortmix.model;

/**
 * Exception class which is thrown when no text is set
 *
 * @author Dariusz Opitek
 * @version 1.2
 */
public class NoTextInputException extends Exception {

    /**
     * Empty constructor
     */
    public NoTextInputException() {
    }

    /**
     * Constructor with message
     *
     * @param message display message
     */
    public NoTextInputException(String message) {
        super(message);
    }
}
