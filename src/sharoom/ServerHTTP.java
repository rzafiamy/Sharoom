package sharoom;

import com.sun.net.httpserver.HttpServer;
import java.io.*;
import java.net.*;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClientHandler;
import model.Config;
import model.FolderCategory;
import model.FolderModel;
import model.LogModel;

/**
 * Un ServerHTTP reçoit les connexions entrantes
 * et l'associe à un thread clientHandler.
 * Date : Fevrier 2015
 * @author Rija ZAFIAMY
 */

public class ServerHTTP extends Thread{
    
    private Config config;

    private FolderModel fileListmusic;
    private FolderModel fileListpicture;
    private FolderModel fileListdocument;
    private FolderModel fileListvideo;
    
    private LogManager logmanager;
    
    public ServerHTTP(Config _config){
        
            this.config   = _config;
            this.fileListdocument = new FolderModel(FolderCategory.DOCUMENT);
            this.fileListvideo = new FolderModel(FolderCategory.VIDEO);
            this.fileListpicture = new FolderModel(FolderCategory.PICTURE);
            this.fileListmusic = new FolderModel(FolderCategory.MUSIC);
    }
    
    //--------------------------------------------------------------------------
    // GESTION DE LA LISTE DES FICHIERS PARGTAGES
    //--------------------------------------------------------------------------    
   public void initSharedFile(String _ctg,FolderModel liste){
         // music category
       if(_ctg.compareTo(FolderCategory.MUSIC.toString())==0){
           this.fileListmusic = liste;
       }
       // picture category
       else if(_ctg.compareTo(FolderCategory.PICTURE.toString())==0){
           this.fileListpicture = liste;
       }
      // video category
      else if(_ctg.compareTo(FolderCategory.VIDEO.toString())==0){
          this.fileListvideo = liste;
      }
        // document category
      else if(_ctg.compareTo(FolderCategory.DOCUMENT.toString())==0){
          this.fileListdocument = liste;
      }
    }
    
   public void deleteAllSharedFile(String _ctg){
       // music category
       if(_ctg.compareTo(FolderCategory.MUSIC.toString())==0){
           this.fileListmusic.deleteAll();
       }
       // picture category
       else if(_ctg.compareTo(FolderCategory.PICTURE.toString())==0){
           this.fileListpicture.deleteAll();
       }
      // video category
      else if(_ctg.compareTo(FolderCategory.VIDEO.toString())==0){
          this.fileListvideo.deleteAll();
      }
        // document category
      else if(_ctg.compareTo(FolderCategory.DOCUMENT.toString())==0){
          this.fileListdocument.deleteAll();
      }
   }
 
   public void deleteSharedFile(String _ctg,String _fname){
       // music category
       if(_ctg.compareTo(FolderCategory.MUSIC.toString())==0){
           this.fileListmusic.delete(_fname);
       }
       // picture category
       else if(_ctg.compareTo(FolderCategory.PICTURE.toString())==0){
           this.fileListpicture.delete(_fname);
       }
      // video category
      else if(_ctg.compareTo(FolderCategory.VIDEO.toString())==0){
          this.fileListvideo.delete(_fname);
      }
        // document category
      else if(_ctg.compareTo(FolderCategory.DOCUMENT.toString())==0){
          this.fileListdocument.delete(_fname);
      }
   }
   
   public FolderModel[] sharedToArray(){
       
       FolderModel [] data = new FolderModel[4];
       
       data[0] = this.fileListmusic;
       data[1] = this.fileListpicture;
       data[2] = this.fileListdocument;
       data[3] = this.fileListvideo;
       
       return data;
   }
   
    //--------------------------------------------------------------------------
    // GESTION DU DEMARRAGE / ARRET
    //--------------------------------------------------------------------------
    @Override
    public void run() {
      
        InetSocketAddress addr = new InetSocketAddress(this.config.getConfigVariable("IP"),Integer.parseInt(this.config.getConfigVariable("PORT")));
        
        HttpServer server = null;
        
        try {
            server = HttpServer.create(addr,0);
            
            server.createContext("/", new ClientHandler(this));
    
            server.setExecutor(Executors.newCachedThreadPool());
    
            server.start();
        
        } catch (IOException ex) {
            Logger.getLogger(ServerHTTP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        while(true){
            
        }
   }
   
    public void kill(){
        Thread.currentThread().interrupt();
    }

    //--------------------------------------------------------------------------
    // GESTION LOGS
    //--------------------------------------------------------------------------   
   
   public void setLogManager(LogManager logman){
       this.logmanager = logman;
   }
   
   public void Log(LogModel log){
       this.logmanager.addLog(log);
   }
   
   
   //--------------------------------------------------------------------------
   // Getter / Setter
   //--------------------------------------------------------------------------

    public Config getConfig() {
        return config;
    }

    public void setConfig(Config config) {
        this.config = config;
    }
   
}