package model;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Gestionnaire des configurations de sharoom HTTP
 * Date : Fevrier 2015
 * @author Rija ZAFIAMY
 */
public class Config {
    
    private static HashMap <String,String> config = new HashMap<>();
    
    public Config(){
        initDefault();
    }
    
    public void setConfigVariable(String key,String value){
        config.put(key, value);
    }
    
    public String getConfigVariable(String key){
        if(config.containsKey(key)){
            return config.get(key);
        }
        return null;
    }
    
    private void initDefault(){
        
        config.put("PORT","7885");
        
        try {
            config.put("IP",Inet4Address.getLocalHost().getHostAddress());
        } catch (UnknownHostException ex) {
            config.put("IP","localhost");
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
