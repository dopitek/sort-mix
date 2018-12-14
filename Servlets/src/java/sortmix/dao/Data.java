package sortmix.dao;

/**
 * Class for storing data inserted to and read from database
 *
 * @author Dariusz Opitek
 * @version 1.3
 */
public class Data {

    /**
     * stores input text
     */
    private String initText;

    /**
     * Sets input text
     *
     * @param text text to be analysed
     */
    public void setInitText(String text) {
        this.initText = text;
    }

    /**
     * Gets input text
     *
     * @return returns input text
     */
    public String getInitText() {
        return this.initText;
    }

    /**
     * stores result text
     */
    private String resultText;

    /**
     * Sets result text
     *
     * @param text result text
     */
    public void setResultText(String text) {
        this.resultText = text;
    }

    /**
     * Gets result text
     *
     * @return returns result text
     */
    public String getResultText() {
        return this.resultText;
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

    /**
     * stores date of calculation
     */
    private String date;

    /**
     * Sets date of calculation
     *
     * @param date sets date of calculation
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets date of calculation
     *
     * @return returns date of calculation
     */
    public String getDate() {
        return this.date;
    }
}
