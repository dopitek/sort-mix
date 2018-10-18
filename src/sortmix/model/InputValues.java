/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmix.model;

import sortmix.common.SortingMode;

/**
 *
 * @author dariu
 */
public class InputValues {
    private String fileName;
    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public String getFileName(){
        return this.fileName;
    }
    
    private SortingMode sortingMode;
    public void setSortingMode(SortingMode sortingMode)
    {
        this.sortingMode = sortingMode;
    }
    public SortingMode getSortingMode(){
        return this.sortingMode;
    }
}
