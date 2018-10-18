/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmix.program;

import sortmix.common.SortingMode;
import sortmix.model.InputValues;

/**
 *
 * @author dariu
 */
public class ArgsParser {
        public InputValues parse(String[] args) {
        InputValues values = new InputValues();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-i":
                    if (args.length > i + 1) {
                        values.setFileName(args[i + 1]);
                    }
                    break;
                case "-s":
                    values.setSortingMode(SortingMode.Sort);
                    break;
                case "-m":
                    values.setSortingMode(SortingMode.Mix);
                    break;
                default: break;
            }
        }

        return values;
    }
}
