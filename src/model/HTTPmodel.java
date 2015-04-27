package model;

import java.util.ArrayList;

/**
 * HTTPmodel définit la page web à afficher
 * sur le navigateur du client.
 * Date : Fevrier 2015
 * @author Rija ZAFIAMY
 */
public class HTTPmodel {
    
    private int code;
    private String header;
    private String headPage;
    private String footPage;
    private String page;
    private ContentType mime;
    private Config config;
    
    public HTTPmodel(){
        this.mime = new ContentType();
        this.code = 200;
        config = new Config();
        this.initHead();
    }
    
    //--------------------------------------------------------------------------
    // REINITIALISE LE MODEL HTTP, PAGE CSS,JS,TYPE-MIMES,... 
    //--------------------------------------------------------------------------
    public void resetHTTPmodel(){
        
        this.mime = new ContentType();
        this.code = 200;
        config = new Config();
        this.initHead();
    }
    
    //--------------------------------------------------------------------------
    // INITIALISE LES EN-TETES DE PAGE: lien CSS, JS , JQUERY, title
    // Charger une seule fois.
    //--------------------------------------------------------------------------    
    private void initHead(){
        
        this.headPage = new String("");
        this.headPage+="<head>\n" +
              "<title> Sharoom mobile</title>\n"+
              "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \n"+
              "<link rel=\"stylesheet\" href=\"http://code.jquery.com/mobile/1.0.1/jquery.mobile-1.0.1.min.css\" />\n" +
              "<script src=\"http://code.jquery.com/jquery-1.6.4.min.js\"></script>\n" +
              "<script src=\"http://code.jquery.com/mobile/1.0.1/jquery.mobile-1.0.1.min.js\"></script>\n" +
              "</head>\n";
        
        this.footPage = new String("");
        this.footPage+="<div data-role=\"footer\" data-theme=\"a\">\n" +
                        "<!-- footer -->\n" +
                        "<span>elio production 2014</span>\n" +
                    "</div>\n</div>\n";
        
    }
    
    //--------------------------------------------------------------------------
    // EN-TETE DE REQUETE HTTP EN REPONSE D'UNE REQUETE GET
    //--------------------------------------------------------------------------
    public String Header(String filetype,long filesize){
        
        this.header = new String("");
        this.header+="HTTP/1.1 "+this.code+" OK\n";
        this.header+="Date:Sun, 11 May 2014 15:08:49 GMT\n";
        this.header+="Server: Apache\n";
        this.header+="Connection:keep-alive"+"\n";
        this.header+="Content-Length: "+filesize+"\n";
        this.header+="Content-Type: "+this.mime.getTypeMime(filetype)+"\n";
        this.header+="Keep-Alive: timeout=10, max=100\n\n";
        return this.header;
    }

    public String Header2(String filetype,long filesize){
        
        this.header = new String("");
        this.header+="HTTP/1.1 206 Partial Content\n";
        this.header+="Date:Sun, 11 May 2014 15:08:49 GMT\n";
        this.header+="Server: Apache\n";
        this.header+="Connection:keep-alive"+"\n";
        //this.header+="Content-Range: bytes\n";
        this.header+="Content-Length: "+filesize+"\n";
        this.header+="Content-Type: "+this.mime.getTypeMime(filetype)+"\n";
        if(filetype.contains("pdf")){
            this.header+="Content-Transfer-Encoding:binary\n";
        }
        this.header+="Keep-Alive: timeout=5, max=100\n\n";
        return this.header;
    }
        
    //--------------------------------------------------------------------------
    // PAGE WEB A ENVOYER AU CLIENT EN REPONSE D'UNE REQUETE
    //--------------------------------------------------------------------------    
    public String getBannerInfo(String pageTitle){
        
        String bannerPage = new String("");
        bannerPage+="<div data-role=\"page\" id=\"home\">\n" +
                    "<div data-role=\"header\"  data-theme=\"a\">\n" +
                "<a href=\"http://"+config.getConfigVariable("IP")+":"+config.getConfigVariable("PORT")+"/\" data-role=\"button\">HOME</a>\n"+
                        "<h1>"+pageTitle.toUpperCase()+"</h1>\n"+
                    "</div>\n";
        
        return bannerPage;
    } 
    
    public String HomePage(){
        
        this.page = new String("<HTML>\n");
        
        String content = new String();
        content+= "<div data-role=\"content\">\n" +
                        "<!-- contenu -->\n" +
                        "<a href=\"http://"+config.getConfigVariable("IP")+":"+config.getConfigVariable("PORT")+"/music.html\" data-role=\"button\">Music</a>\n" +
                        "<a href=\"http://"+config.getConfigVariable("IP")+":"+config.getConfigVariable("PORT")+"/picture.html\" data-role=\"button\">Picture</a>\n" +
                        "<a href=\"http://"+config.getConfigVariable("IP")+":"+config.getConfigVariable("PORT")+"/video.html\" data-role=\"button\">Video</a>\n" +
                        "<a href=\"http://"+config.getConfigVariable("IP")+":"+config.getConfigVariable("PORT")+"/document.html\" data-role=\"button\">Document</a>\n" +
                    "</div>\n";
        this.page+=this.headPage+this.getBannerInfo("home")+content+this.footPage+"</HTML>\n";
        
        return this.page;
    }
    
    public String FileExplorerPage(FolderModel _fmodel,String ctg){
        
        ArrayList<FileModel> liste = _fmodel.fetchAllToArray();
        
        this.page = new String("<HTML>\n");
        String content = new String("");
        content+= "<div data-role=\"content\">\n" +
                        "<!-- contenu -->\n";
        content+= "<ul data-role=\"listview\" data-filter=\"true\">\n";
 
            for(int i=0;i<liste.size();i++){
                content+="<li><a href=\"http://"+config.getConfigVariable("IP")+":"+config.getConfigVariable("PORT")+"/browse/"+
                        ctg+"/"+i+"/"+liste.get(i).getName()+"\" data-ajax=\"false\">"+liste.get(i).getName()+"</a><li>\n";
            }
            content+="</ul>\n";
            content+= "</div>\n";
        
        this.page+=this.headPage+this.getBannerInfo(ctg)+content+this.footPage+"</HTML>\n";
        
        return this.page;
    }
    
    //--------------------------------------------------------------------------
    // RECUPERE LA REQUETE DU CLIENT, SI "GET" RECUPERE L'URL DEMANDEE 
    //--------------------------------------------------------------------------  
    public String getRequestType(String req){
        
        String tmp[] = req.split("\n");
        
        if(tmp!=null){
            
            if(tmp[0].startsWith("GET")){
                
                return "GET";
            }
        }
        
        return "BAD";
    }
    
    public String getRequestedUrl(String req){
        
        String tmp[] = req.split("\n");
        
        if(tmp!=null){
            String tmp2[] = tmp[0].split(" ");
            if(tmp2!=null){
                return tmp2[1];
            }
        }
        
        return "index.html";
    }
    
    public int getRangeRequest(String range){
        
        return 0;
    }
    //--------------------------------------------------------------------------
    // GESTION AFFICHAGE LECTEUR AUDIO VIDEO , APERCU IMAGE, DOCUMENT
    //--------------------------------------------------------------------------
    public String ImageViewer(FileModel prev,int np,FileModel next,int nn,FileModel f,int num){
        
        String content = new String("");
        
        content+= "<div data-role=\"content\">\n" +
                        "<!-- contenu -->\n";        
        
        content+="<img src=\"http://"+config.getConfigVariable("IP")+":"+config.getConfigVariable("PORT")+
                    "/picture/download/"+num+"/"+f.getName()+"\" style=\" height:100%;width:100%;\">\n";
        
        if(prev!=null){
            content+="<a href=\"http://"+config.getConfigVariable("IP")+":"+config.getConfigVariable("PORT")+"/picture/"+np+"/"+prev.getName()+"\" data-role=\"button\">PREV</a>\n";
        }
        if(next!=null){
            content+="<a href=\"http://"+config.getConfigVariable("IP")+":"+config.getConfigVariable("PORT")+"/picture/"+nn+"/"+next.getName()+"/\" data-role=\"button\">NEXT</a>\n";
        }
        content+="</div>\n";
        
        this.page=this.headPage+this.getBannerInfo(f.getName())+content+this.footPage+"</HTML>\n";
        
        return this.page;
    }
    
    public String MusicPlayer(FileModel prev,int np,FileModel next,int nn,FileModel f,int num){
        
        String content = new String("");
        
        content+= "<div data-role=\"content\">\n" +
                        "<!-- contenu -->\n";        
        
        content+="<a href=\"http://"+config.getConfigVariable("IP")+":"+config.getConfigVariable("PORT")+
                    "/music/download/"+num+"/"+f.getName()+"\">PLAY</a>\n";
        
        if(prev!=null){
            content+="<a href=\"http://"+config.getConfigVariable("IP")+":"+config.getConfigVariable("PORT")+"/music/"+np+"/"+prev.getName()+"\" data-role=\"button\">PREV</a>\n";
        }
        if(next!=null){
            content+="<a href=\"http://"+config.getConfigVariable("IP")+":"+config.getConfigVariable("PORT")+"/music/"+nn+"/"+next.getName()+"/\" data-role=\"button\">NEXT</a>\n";
        }
        content+="</div>\n";
        
        this.page=this.headPage+this.getBannerInfo(f.getName())+content+this.footPage+"</HTML>\n";
        
        return this.page;
    }
    
    public String DocumentPlayer(FileModel prev,int np,FileModel next,int nn,FileModel f,int num){
        
        String content = new String("");
        
        content+= "<div data-role=\"content\">\n" +
                        "<!-- contenu -->\n";        
        
        content+="<a href=\"http://"+config.getConfigVariable("IP")+":"+config.getConfigVariable("PORT")+
                    "/document/download/"+num+"/"+f.getName()+"\">"+f.getName()+"</a>\n";
        /*content+= 
                "<a href=\"http://"+config.getConfigVariable("IP")+"%3A"+config.getConfigVariable("PORT")+"%2Fdocument%2Fdownload%2F"+num+"%2F"+f.getName()+"\" >"+f.getName()+"</a>";
        */
        if(prev!=null){
            content+="<a href=\"http://"+config.getConfigVariable("IP")+":"+config.getConfigVariable("PORT")+"/document/"+np+"/"+prev.getName()+"\" data-role=\"button\">PREV</a>\n";
        }
        if(next!=null){
            content+="<a href=\"http://"+config.getConfigVariable("IP")+":"+config.getConfigVariable("PORT")+"/document/"+nn+"/"+next.getName()+"/\" data-role=\"button\">NEXT</a>\n";
        }
        content+="</div>\n";
        
        this.page=this.headPage+this.getBannerInfo(f.getName())+content+this.footPage+"</HTML>\n";
        
        return this.page;
    }
}
