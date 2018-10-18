package sortmix.program;

import sortmix.common.SortingMode;

/**
 * Class used to store input vales get from user
 *
 * @author Dariusz Opitek
 * @version 1.0
 */
public class InputData {

    /**
     * stores file name
     */
    private String fileName;

    /**
     * Sets file name
     *
     * @param fileName name of file
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Gets file name
     *
     * @return return name of file
     */
    public String getFileName() {
        return this.fileName;
    }

    /**
     * stores selected sorting mode
     */
    private SortingMode sortingMode;

    /**
     * Sets sorting mode
     *
     * @param sortingMode sorting mode
     */
    public void setSortingMode(SortingMode sortingMode) {
        this.sortingMode = sortingMode;
    }

    /**
     * Gets sorting mode
     *
     * @return returns sorting mode
     */
    public SortingMode getSortingMode() {
        return this.sortingMode;
    }
}
