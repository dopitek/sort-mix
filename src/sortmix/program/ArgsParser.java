/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortmix.program;

import sortmix.common.SortingMode;
import sortmix.model.Model;

/**
 *
 * @author dariu
 */
public class ArgsParser {
        public Model Parse(String[] args) {
        Model values = new Model();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-i":
                    if (args.length > i + 1) {
                        values.setInput(args[i + 1]);
                    }
                    break;
                case "-s":
                    values.setMode(SortingMode.Sort);
                    break;
                case "-m":
                    values.setMode(SortingMode.Mix);
                    break;
            }
        }

        return values;
    }
}
