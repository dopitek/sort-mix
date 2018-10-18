/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmix.common;

import sortmix.model.InputValues;

/**
 *
 * @author dariu
 */
public interface IUserInterface {
    InputValues getInput(InputValues values);
    void present(String value);    
    void error(String value);

}
