package sortmix.consoleInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Scanner;
import sortmix.program.InputData;

/**
 * Command line user interface
 *
 * @author Dariusz Opitek
 * @version 1.2
 */
public class ConsoleUserInterface {

    /**
     * Gets data from the user interface to process data
     *
     * @param values actual data parsed from args array
     * @return returns data get from user
     */
    public InputData fillMissingData(InputData values) {

        while (true) {
            if (values.getText() != null
                    && values.getSortingMode() != null) {
                break;
            }

            if (values.getText() == null) {
                System.out.print("Enter text: ");
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    String s = br.readLine();
                    values.setText(s);
                } catch (IOException ex) {
                    error(ex.getMessage());
                }
            }

            if (values.getSortingMode() == null) {
                Scanner scanner = new Scanner(System.in, "UTF-8");
                System.out.print("Enter arrange mode s for sort, m for mix: ");
                String arrangeString = scanner.next().toLowerCase(Locale.ENGLISH);
                if (arrangeString.equals("s")) {
                    values.setSortingMode("s");
                }
                if (arrangeString.equals("m")) {
                    values.setSortingMode("m");
                }
            }
        }
        return values;
    }

    /**
     * Puts text to the user interface
     *
     * @param value text to be displayed
     */
    public void present(String value) {
        System.out.println(value);
    }

    /**
     * Puts errors to the user interface
     *
     * @param value message to be displayed
     */
    public void error(String value) {
        System.out.println("Error occured: " + value);
    }

}
