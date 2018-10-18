/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmix.program;

import sortmix.exceptions.NonSortingModeException;
import sortmix.consoleInterface.ConsoleUserInterface;
import sortmix.common.IUserInterface;
import sortmix.exceptions.ErrorReadingFileException;
import sortmix.model.InputValues;
import sortmix.model.Model;

/**
 *
 * @author Dariusz Opitek
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        InputValues inputValues = new ArgsParser().parse(args);

        IUserInterface userInterface = new ConsoleUserInterface();

        inputValues = userInterface.getInput(inputValues);

        Model model = new Model(inputValues.getFileName());

        String text;
        try {
            switch (inputValues.getSortingMode()) {
                case Sort:
                    text = model.getSortedString();
                    break;
                case Mix:
                    text = model.getMixedString();
                    break;
                default:
                    throw new NonSortingModeException("Sorting mode not supported: " + inputValues.getSortingMode().name());
            }
            userInterface.present(text);
        } catch (ErrorReadingFileException | NonSortingModeException ex) {
            userInterface.error(ex.getMessage());
        }

    }
}
