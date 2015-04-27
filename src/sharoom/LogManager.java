package sharoom;

import java.util.ArrayList;
import model.LogModel;
import sharoom.view.LogPanel;

/**
 * Un LogManager gère l'ajout et suppression
 * de log.
 * Date : Fevrier 2015
 * @author Rija ZAFIAMY
 */
public class LogManager {
  
    private ArrayList<LogModel> listeLog;
    private LogPanel view;
    
    public LogManager(LogPanel view){
        
        this.listeLog = new ArrayList();
        this.view = view;
    }
    
    public void addLog(LogModel log){
        
        this.listeLog.add(log);
        // Mise à jour de la table
        this.view.addTable(this.logToObject());
    }
    
    public Object[][] logToObject(){
        
        if(this.listeLog.size()>0){
            
            Object data[][] = new Object[this.listeLog.size()][5];
            int i=0;
            int j=this.listeLog.size()-1;
            for(;j>=0;j--){
                
                data[i][0] = j+1;
                data[i][1] = listeLog.get(j).getHostname();
                data[i][2] = listeLog.get(j).getPort();
                data[i][3] = listeLog.get(j).getUrl();
                
                i++;
            }
            return data;
        }
        
        return null;
    }
}
