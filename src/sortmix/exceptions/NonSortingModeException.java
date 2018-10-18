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
public class NonSortingModeException extends Exception {
        public NonSortingModeException() {
    }

    /**
     * Constructor
     *
     * @param message display message
     */
    public NonSortingModeException(String message) {
        super(message);
    }
}
