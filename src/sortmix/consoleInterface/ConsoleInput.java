/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmix.consoleInterface;

import java.util.Scanner;
import sortmix.exceptions.FileNotFoundException;
import sortmix.exceptions.NonSortingModeException;
import sortmix.model.Model;

/**
 *
 * @author dariu
 */
public class ConsoleInput {

    public Model GetInput(Model values) {
        
        while (true) {
            try {
                values.validate();
                break;
            } catch (FileNotFoundException exception) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter filename: ");
                values.setInput(scanner.next());
            } catch (NonSortingModeException exception) {

            }
        }
    }


}
