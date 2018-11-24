package sortmix.program;

/**
 * Class used to store input vales get from user
 *
 * @author Dariusz Opitek
 * @version 1.1
 */
public class InputData {

    /**
     * stores text
     */
    private String text;

    /**
     * Sets text
     *
     * @param text text to be analysed
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets text
     *
     * @return returns text
     */
    public String getText() {
        return this.text;
    }

    /**
     * stores selected sorting mode
     */
    private String sortingMode;

    /**
     * Sets sorting mode
     *
     * @param sortingMode sorting mode
     */
    public void setSortingMode(String sortingMode) {
        this.sortingMode = sortingMode;
    }

    /**
     * Gets sorting mode
     *
     * @return returns sorting mode
     */
    public String getSortingMode() {
        return this.sortingMode;
    }
}
