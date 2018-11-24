package sortmix.settings;

/**
 * Class for holding Settings, especially port number
 *
 * @author Dariusz Opitek
 * @version 1.2
 */
public class Settings {
    
    /**
     * stores port value
     */
    private int port;
    
    /**
     * sets port value
     * @param port value to be set
     */
    public void setPort(int port){
        this.port = port;
    }
    
    /**
     * gets port value
     * @return returns port value
     */
    public int getPort(){
        return this.port;
    }
}
