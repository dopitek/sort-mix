package sortmix.program;

import sortmix.exceptions.NonSortingModeException;
import sortmix.consoleInterface.ConsoleUserInterface;
import sortmix.common.IUserInterface;
import sortmix.exceptions.ErrorReadingFileException;
import sortmix.model.FileReadModel;
import sortmix.model.TextSorterModel;

/**
 * Main class of the application which sorts or mixes content of given file.
 * Result is presented to the user interface.
 *
 * @author Dariusz Opitek
 * @version 1.0
 */
public class Program {

    /**
     * Main method of the application Arguments should contain following
     * arguments: -i %filename% - for text file -s or -m - for sort or mix
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        InputData inputValues = new ArgsParser().parse(args);

        IUserInterface userInterface = new ConsoleUserInterface();

        inputValues = userInterface.getInput(inputValues);

        try {
            FileReadModel fileReadModel = new FileReadModel(inputValues.getFileName());
            String text = fileReadModel.getText();

            TextSorterModel textSorterModel = new TextSorterModel(text, inputValues.getSortingMode());
            String sortedText = textSorterModel.getResultText();

            userInterface.present(sortedText);
        } catch (ErrorReadingFileException | NonSortingModeException ex) {
            userInterface.error(ex.getMessage());
        }

    }
}
