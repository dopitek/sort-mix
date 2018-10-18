/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmix.consoleInterface;

import sortmix.common.IUserInterface;
import java.util.Scanner;
import sortmix.common.SortingMode;
import sortmix.model.InputValues;

/**
 *
 * @author dariu
 */
public class ConsoleUserInterface implements IUserInterface {

    @Override
    public InputValues getInput(InputValues values) {

        while (true) {
            if (!values.getFileName().equals("") && values.getSortingMode() != SortingMode.None) 
                break;
            
            if (values.getFileName().equals("")) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter filename: ");
                values.setFileName(scanner.next());
            }

            if (values.getSortingMode() == SortingMode.None) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter arrange mode s for sort, m for mix: ");
                String arrangeString = scanner.next().toLowerCase();
                if (arrangeString.equals("s")) {
                    values.setSortingMode(SortingMode.Sort);
                }
                if (arrangeString.equals("m")) {
                    values.setSortingMode(SortingMode.Mix);
                }
            }
        }
        return values;
    }

    @Override
    public void present(String value) {
        System.out.println(value);
    }

    @Override
    public void error(String value) {
        System.out.println("Error occured: " + value);
    }

}
