/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmix.dao;

import java.util.Date;
import sortmix.common.SortingMode;
/**
 *
 * @author dariu
 */
public class Data {
        /**
     * stores text to be processed
     */
    private String initText;

    /**
     * Sets text
     *
     * @param text text to be analysed
     */
    public void setInitText(String text) {
        this.initText = text;
    }

    /**
     * Gets text
     *
     * @return returns text
     */
    public String getInitText() {
        return this.initText;
    }
    
            /**
     * stores text to be processed
     */
    private String resultText;

    /**
     * Sets text
     *
     * @param text text to be analysed
     */
    public void setResultText(String text) {
        this.resultText = text;
    }

    /**
     * Gets text
     *
     * @return returns text
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
     * stores selected sorting mode
     */
    private String date;

    /**
     * Sets sorting mode
     *
     * @param sortingMode sorting mode
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets sorting mode
     *
     * @return returns sorting mode
     */
    public String getDate() {
        return this.date;
    }
}
