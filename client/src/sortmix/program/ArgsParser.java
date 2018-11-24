package sortmix.program;

/**
 * Class used to process values from command line args
 *
 * @author Dariusz Opitek
 * @version 1.2
 */
public class ArgsParser {

    /**
     * Parse values from the command line args
     *
     * @param args command line args
     * @return return parsed input data
     */
    protected InputData parse(String[] args) {
        InputData values = new InputData();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-t":
                    if (args.length > i + 1) {
                        values.setText(args[i + 1]);
                    }
                    break;
                case "-s":
                    values.setSortingMode("s");
                    break;
                case "-m":
                    values.setSortingMode("m");
                    break;
                default:
                    break;
            }
        }

        return values;
    }
}
