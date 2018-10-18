/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmix.model;

import sortmix.exceptions.FileNotFoundException;
import java.io.File;
import sortmix.common.SortingMode;
import sortmix.exceptions.NonSortingModeException;

/**
 *
 * @author dariu
 */
public class Model {
    private String input;
    private SortingMode sortingMode;
    
    public String getInput(){
        return this.input;
    }
    
    public void setInput(String value){
        this.input = value;
    }
    
    public SortingMode getMode(){
        return this.sortingMode;
    }
    
    public void setMode(SortingMode mode)
    {
        this.sortingMode = mode;
    }
    
    public void validate() throws FileNotFoundException, NonSortingModeException{
        File f = new File(this.input);
        if(!f.exists() || f.isDirectory()) { 
            throw new FileNotFoundException();
        }
        if (this.sortingMode == SortingMode.None)
            throw new NonSortingModeException();
    }

}


