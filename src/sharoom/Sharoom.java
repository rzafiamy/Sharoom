package sharoom;

import java.util.HashMap;
import model.Config;
import sharoom.view.SharoomGUI;

/**
 * Sharoom est la classe
 * principale de Sharoom.
 * Date : Fevrier 2015
 * @author Rija ZAFIAMY
 */
public class Sharoom {

   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        int nbargs = args.length;
        
        if(nbargs > 0)
        {
            HashMap<String,String> parameters = new HashMap<String,String>();
            
            System.out.println("Welcome to Sharoom command  line! ");
            System.out.println("Author: Rija ZAFIAMY");
            System.out.println("2014 - 2015 ");
            

            
            for(int i=0;i<(nbargs-1);i++)
            {               
                parameters.put(args[i],args[i+1]);
            }
  
            // run server
            Config conf = new Config();
            conf.setConfigVariable("IP",parameters.get("-ip"));
            conf.setConfigVariable("PORT",parameters.get("-p"));
            
            System.out.println(conf.getConfigVariable("IP")+":"+conf.getConfigVariable("PORT"));
            
            ServerHTTP server = new ServerHTTP(conf);
            
            server.start();
            
            
        }
        else // graphical interface
        {
            SharoomGUI sg = new SharoomGUI();
            sg.setVisible(true);
        }
          
                
    }
}
