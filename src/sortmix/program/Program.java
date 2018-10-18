/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmix.program;

import sortmix.exceptions.NonSortingModeException;
import sortmix.consoleInterface.ConsoleInput;
import sortmix.consoleInterface.ConsoleOutput;
import sortmix.model.IArrangable;
import sortmix.model.Model;
import sortmix.model.Mixer;
import sortmix.model.Sorter;

/**
 *
 * @author Dariusz Opitek
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model values = new ArgsParser().Parse(args);
        
        values = new ConsoleInput().GetInput(values);
        
        IArrangable arranger;        
        switch(values.getMode())
        {
            case Sort:
                arranger = new Sorter();
                break;
            case Mix:
                arranger = new Mixer();
                break;
            default:
                throw new NonSortingModeException(values.getMode().name());
        }
        
        String result = arranger.Arrange(values.getInput());
        
        new ConsoleOutput().Present(result);
    }
}
            
