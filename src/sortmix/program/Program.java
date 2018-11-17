package sortmix.program;

import sortmix.model.NonSortingModeException;
import sortmix.consoleInterface.ConsoleUserInterface;
import sortmix.model.TextSorterModel;

/**
 * Main class of the application which sorts or mixes content of given text.
 * Result is presented to the user interface.
 *
 * @author Dariusz Opitek
 * @version 1.1
 */
public class Program {

    /**
     * Main method of the application Arguments should contain following
     * arguments: -t "text_to_be_analyzed" -s or -m - for sort or mix
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        InputData inputValues = new ArgsParser().parse(args);

        ConsoleUserInterface userInterface = new ConsoleUserInterface();

        inputValues = userInterface.fillMissingData(inputValues);

        try {
            TextSorterModel textSorterModel = new TextSorterModel(inputValues.getText(), inputValues.getSortingMode());
            String sortedText = textSorterModel.process();

            userInterface.present(sortedText);
        } catch (NonSortingModeException ex) {
            userInterface.error(ex.getMessage());
        }

    }
}
