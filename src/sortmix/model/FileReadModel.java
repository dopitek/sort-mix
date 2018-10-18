package sortmix.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import sortmix.exceptions.ErrorReadingFileException;

/**
 * Class for retrieving text from file
 *
 * @author Dariusz Opitek
 * @version 1.0
 */
public class FileReadModel {

     /**
     * stores name of file to be read
     */
    private final String fileName;

    /**
     * Default constructor
     *
     * @param fileName File name of file to be read
     */
    public FileReadModel(String fileName) {
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
    public String getText() throws ErrorReadingFileException {

        try {
            FileReader fileReader = new FileReader(this.fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            StringBuilder text = new StringBuilder();
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
            }
            return text.toString();
        } catch (FileNotFoundException ex) {
            throw new ErrorReadingFileException("Can't open file " + this.fileName + " " + ex.getMessage());
        } catch (IOException ex) {
            throw new ErrorReadingFileException("Can't read file " + this.fileName + " " + ex.getMessage());
        }
    }
}
