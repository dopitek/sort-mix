package sortmix.exceptions;

/**
 *
 * @author Dariusz Opitek
 * @version 1.0
 */
public class ErrorReadingFileException extends Exception {

    /**
     * Empty constructor
     */
    public ErrorReadingFileException() {
    }

    /**
     * Constructor with message
     *
     * @param message display message
     */
    public ErrorReadingFileException(String message) {
        super(message);
    }
}
