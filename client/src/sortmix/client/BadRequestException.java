/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmix.client;

/**
 *
 * @author dariu
 */
public class BadRequestException extends Exception {
    public BadRequestException() {
    }

    /**
     * Constructor with message
     *
     * @param message display message
     */
    public BadRequestException(String message) {
        super(message);
    }
}
