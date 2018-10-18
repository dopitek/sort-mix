/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmix.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import sortmix.exceptions.ErrorReadingFileException;

/**
 *
 * @author dariu
 */
public class Model {

    private final String fileName;

    public Model(String fileName) {
        this.fileName = fileName;
    }

    public String getInputString() throws ErrorReadingFileException {

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

    public String getSortedString() throws ErrorReadingFileException {

        String text = getInputString();
       
        return text;
    }

    public String getMixedString() throws ErrorReadingFileException{

        String text = getInputString();
       
        return text;
    }
}
