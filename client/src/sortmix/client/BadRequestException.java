package sortmix.client;

/**
 * Exception class which is thrown when BadRequest comes from Server
 *
 * @author Dariusz Opitek
 * @version 1.2
 */
public class BadRequestException extends Exception {
    
    /**
     * Empty constructor
     */
    public BadRequestException() {
    }

    /**
     * Constructor with message
     *
     * @param message display message
     */
    public BadRequestException(String message) {
        super(message);
    }
}
