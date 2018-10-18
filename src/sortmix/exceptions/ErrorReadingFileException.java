/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmix.exceptions;

/**
 *
 * @author Student
 */
public class ErrorReadingFileException extends Exception {

    public ErrorReadingFileException() {
    }

    /**
     * Constructor
     *
     * @param message display message
     */
    public ErrorReadingFileException(String message) {
        super(message);
    }
}
