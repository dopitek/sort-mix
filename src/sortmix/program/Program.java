package sortmix.program;

import sortmix.exceptions.NonSortingModeException;
import sortmix.consoleInterface.ConsoleUserInterface;
import sortmix.common.IUserInterface;
import sortmix.exceptions.ErrorReadingFileException;
import sortmix.model.Model;

/**
 *
 * @author Dariusz Opitek
 * @version 1.0
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        InputData inputValues = new ArgsParser().parse(args);

        IUserInterface userInterface = new ConsoleUserInterface();

        inputValues = userInterface.getInput(inputValues);

        Model model = new Model(inputValues.getFileName());

        try {
            String text = model.getResultText(inputValues.getSortingMode());
            userInterface.present(text);

        } catch (ErrorReadingFileException | NonSortingModeException ex) {
            userInterface.error(ex.getMessage());
        }

    }
}
