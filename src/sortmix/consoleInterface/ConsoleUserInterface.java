package sortmix.consoleInterface;

import java.util.Locale;
import sortmix.common.IUserInterface;
import java.util.Scanner;
import sortmix.common.SortingMode;
import sortmix.program.InputData;

/**
 * Command line user interface
 *
 * @author Dariusz Opitek
 * @version 1.0
 */
public class ConsoleUserInterface implements IUserInterface {

    @Override
    public InputData getInput(InputData values) {

        while (true) {
            if (values.getFileName() != null
                    && values.getSortingMode() != null) {
                break;
            }

            if (values.getFileName() == null) {
                Scanner scanner = new Scanner(System.in, "UTF-8");
                System.out.print("Enter filename: ");
                values.setFileName(scanner.next());
            }

            if (values.getSortingMode() == null) {
                Scanner scanner = new Scanner(System.in, "UTF-8");
                System.out.print("Enter arrange mode s for sort, m for mix: ");
                String arrangeString = scanner.next().toLowerCase(Locale.ENGLISH);
                if (arrangeString.equals("s")) {
                    values.setSortingMode(SortingMode.Sort);
                }
                if (arrangeString.equals("m")) {
                    values.setSortingMode(SortingMode.Mix);
                }
            }
        }
        return values;
    }

    @Override
    public void present(String value) {
        System.out.println(value);
    }

    @Override
    public void error(String value) {
        System.out.println("Error occured: " + value);
    }

}
