package sortmix.common;

import sortmix.program.InputData;

/**
 * Interface for getting and presenting data from/to the user
 * 
 * @author Dariusz Opitek
 * @version 1.0
 */
public interface IUserInterface {

    /**
     * Gets missing data from the user interface to process data
     *
     * @param data actual data parsed from args array
     * @return returns missing data get from user
     */
    InputData getInput(InputData data);

    /**
     * Puts text to the user interface
     *
     * @param text text to be displayed
     */
    void present(String text);

    /**
     * Puts errors to the user interface
     *
     * @param message message to be displayed
     */
    void error(String message);

}
