package sortmix.exceptions;

/**
 * Exception class which is thrown when no supported mode is selected
 * 
 * @author Dariusz Opitek
 * @version 1.0
 */
public class NonSortingModeException extends Exception {

    /**
     * Empty constructor
     */
    public NonSortingModeException() {
    }

    /**
     * Constructor with message
     *
     * @param message display message
     */
    public NonSortingModeException(String message) {
        super(message);
    }
}
