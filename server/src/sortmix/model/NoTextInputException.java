/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmix.model;

/**
 *
 * @author dariu
 */
public class NoTextInputException extends Exception {

    public NoTextInputException() {
    }

    /**
     * Constructor with message
     *
     * @param message display message
     */
    public NoTextInputException(String message) {
        super(message);
    }
}
