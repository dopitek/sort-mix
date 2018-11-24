package sortmix.settings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Class used to process values from command line args
 *
 * @author Dariusz Opitek
 * @version 1.1
 */
public class SettingsParser {

    /**
     * Parse values from the command line args
     *
     * @param args command line args
     * @return return parsed input data
     */
    public Settings parse(String propertiesFileName) {
        Properties properties = new Properties();
        Settings settings = new Settings();

        try (FileInputStream in = new FileInputStream(propertiesFileName)) {
            properties.load(in);
            String portString = properties.getProperty("port");
            int port = Integer.parseInt(portString);
            settings.setPort(port);
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return null;
        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
            return null;
        }

        return settings;
    }
}
