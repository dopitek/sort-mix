package sortmix.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import sortmix.common.SortingMode;
import sortmix.exceptions.ErrorReadingFileException;
import sortmix.exceptions.NonSortingModeException;

/**
 * Main model of the application. Reads file content and arranges text in
 * specified mode.
 *
 * @author Dariusz Opitek
 * @version 1.0
 */
public class Model {

    /**
     * fileName stores file name
     */
    private final String fileName;

    /**
     * Default constructor
     *
     * @param fileName File name of file to be read
     */
    public Model(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Reads all text from file
     *
     * @return returns text get from file
     * @throws ErrorReadingFileException throws custom exception caught while
     * processing file
     *
     */
    private String getInputString() throws ErrorReadingFileException {

        try {
            FileReader fileReader = new FileReader(this.fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String text = "";
            while ((line = bufferedReader.readLine()) != null) {
                text += line;
            }
            return text;
        } catch (FileNotFoundException ex) {
            throw new ErrorReadingFileException("Can't open file " + this.fileName + " " + ex.getMessage());
        } catch (IOException ex) {
            throw new ErrorReadingFileException("Can't read file " + this.fileName + " " + ex.getMessage());
        }
    }

    /**
     * Gets sorted text retrieved from file
     *
     * @return returns sorted text
     * @throws ErrorReadingFileException throws custom exception caught while
     * processing file
     */
    private String getSortedString() throws ErrorReadingFileException {

        String input = getInputString();
        input = input.replaceAll("\\s+", "");
        StringBuilder text = new StringBuilder(input);

        for (int i = 0; i < text.length(); i++) {
            for (int j = i + 1; j < text.length(); j++) {
                if (text.charAt(j) < text.charAt(i)) {
                    char t = text.charAt(j);
                    text.setCharAt(j, text.charAt(i));
                    text.setCharAt(i, t);
                }
            }
        }

        return text.toString();
    }

    /**
     * Gets mixed text retrieved from file
     *
     * @return returns mixed text
     * @throws ErrorReadingFileException throws custom exception caught while
     * processing file
     */
    private String getMixedString() throws ErrorReadingFileException {

        String text = getInputString();

        return text;
    }

    /**
     * Gets text arranged in the specified sorting mode
     *
     * @param sortingMode sorting mode used to arrange text
     * @return returns arranged text
     * @throws ErrorReadingFileException throws custom exception caught while
     * processing file
     * @throws NonSortingModeException throws custom exception caught when
     * sorting mode not supported
     */
    public String getResultText(SortingMode sortingMode) throws ErrorReadingFileException, NonSortingModeException {
        String text;
        switch (sortingMode) {
            case Sort:
                text = getSortedString();
                break;
            case Mix:
                text = getMixedString();
                break;
            default:
                throw new NonSortingModeException("Sorting mode not supported: " + sortingMode.name());
        }
        return text;
    }
}
