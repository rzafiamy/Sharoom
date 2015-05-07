package model;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import sharoom.ServerHTTP;

/**
 * Gestionnaire de requête HTTP
 * Date : Fevrier 2015
 * @author Rija ZAFIAMY
 */
public class ClientHandler implements HttpHandler {
    
    private FolderModel sharedFile[];
    private String page;
    private HTTPmodel httpm;
    private ContentType content;
    private ServerHTTP server;
    
    private static final HashMap<String,Integer> ctgpage = new HashMap<String,Integer>(){
        {   put("music",0);
            put("picture",1);
            put("document",2);
            put("video",3);};  
    };
    
    public ClientHandler(ServerHTTP _serv){
        
        server = _serv;
        sharedFile = server.sharedToArray();
        httpm = new HTTPmodel(server.getConfig());
        this.page = httpm.HomePage();
        content = new ContentType();
    }
    
    /**
     * Gère les requetes utilisateur
     * @param exchange
     * @throws IOException 
     */
    public void handle(HttpExchange exchange) throws IOException {
    
        // rafraichie les données
        this.sharedFile = this.server.sharedToArray();
        
        // Log la requête
        this.server.Log(new LogModel(exchange.getRemoteAddress().getPort(),
        exchange.getRemoteAddress().getHostName(),exchange.getRequestURI().toString(), 0));
        
        if(exchange.getRequestMethod().toUpperCase().compareTo("GET")==0){    
            
            String freq = exchange.getRequestURI().toString();
            Headers head = exchange.getResponseHeaders();
            exchange.sendResponseHeaders(200,0);
            OutputStream out = exchange.getResponseBody();
                        
            // Le client accede à une des pages music,picture,document,video
            // on envoi la liste des fichiers dans music
            if((freq.compareTo("/music.html")==0)||
                (freq.compareTo("/picture.html")==0)||
                (freq.compareTo("/document.html")==0)||
                (freq.compareTo("/video.html")==0)){
                
                int indice = 0;
                int end = freq.indexOf(".html");
                String ctg = ""+freq.subSequence(1, end);
                
                if(ctgpage.containsKey(ctg)){
                    indice = ctgpage.get(ctg);
                }
                
                head.add("Content-Type",content.getTypeMime("html"));
                this.page = this.httpm.FileExplorerPage(sharedFile[indice],ctg);
                head.add("Content-Length",""+this.page.length());
                out.write(this.page.getBytes());
                this.page = httpm.HomePage();
                out.close();

            }
             // Le client demande un fichier
            else if(freq.startsWith("/browse/")){
                
                handle2(freq,head,out);
                
            }
             // La requête du client est inconnue -> page d'accueil
            else{
                head.add("Content-Type",content.getTypeMime("html"));
                this.page = httpm.HomePage();
                head.add("Content-Length",""+this.page.length());
                out.write(this.page.getBytes());
                out.close();
            }
        }// fin si requête = GET
        else if(exchange.getRequestMethod().toUpperCase().compareTo("PUT")==0){
            
        }// fin si requête = PUT
        
    }
    /**
     * Traite la demande de fichier du client
     * @param freq
     * @param head
     * @param out
     * @throws IOException 
     */
    public void handle2(String freq,Headers head,OutputStream out) throws IOException{
        
        //Format :/browse/music/2/GASIKARA%20-%20BABA.mp3
        String req[] = new String[5];
        req = freq.split("/");
        
        // demande un d'ouvrir un fichier de categorie music,picture,document ou video
        if((req[2].compareTo("music")==0)||
           (req[2].compareTo("picture")==0)||
           (req[2].compareTo("document")==0)||
           (req[2].compareTo("video")==0)){
            
            int indice = 0;
            if(ctgpage.containsKey(req[2])){
                    indice = ctgpage.get(req[2]);
            }
            FileModel fm= this.sharedFile[indice].find2(Integer.parseInt(req[3]));
            head.add("Content-Type",content.getTypeMime(fm.getType()));
            head.add("Content-Length",""+fm.getSize());
            this.sendFile(out, fm);
            out.close();
        }
        else{
            // La requête du client est inconnue -> page d'accueil
            head.add("Content-Type",content.getTypeMime("html"));
            this.page = httpm.HomePage();
            head.add("Content-Length",""+this.page.length());
            out.write(this.page.getBytes());
            out.close();
        }
      
    }
  
    /**
     * Envoi un fichier ou une page web au client.
     * @param out
     * @param file 
     */
    public void sendFile(OutputStream out,FileModel file){
        
        try{
                //Instantiate the file object
                File f = new File(file.getAbsolutePath());
                DataInputStream dIn = new DataInputStream(new FileInputStream(f));
                
                byte []b = new byte[1024];
                int filesize = (int)f.length();
                
                if(filesize>=1024){ 
                    int rest = filesize%1024; 
                    int size = filesize-rest;
                    
                    for(int i=0;i<size;i=i+1024){
                        dIn.read(b);
                        out.write(b);
                    }
                    if(rest>0){ // if size is not multiple of 1024
                        byte []c = new byte[rest];
                        dIn.read(c);
                        out.write(c);
                    }
                }
                else{
                    byte []d = new byte[filesize];
                    dIn.read(b);
                    out.write(b,0,filesize);
                }
                dIn.close();
                
         }catch(Exception e){
                System.out.println("Error is:" + e.getMessage());
         }
    }
}
