package model;

/**
 * LogModel définit un modele de fichier log.
 * Nécéssaire pour journaliser les accès aux
 * fichiers partagés.
 * Date : Fevrier 2015
 * @author Rija ZAFIAMY
 */
public class LogModel {
    
    private int port;
    private int size;
    private String hostname;
    private String url;
    
    public LogModel(int _port,String _host,String _url,int _size){
        this.port = _port;
        this.hostname = _host;
        this.url = _url;
        this.size = _size;
    }
    public LogModel(int _port,String _host,String _url){
        this.port = _port;
        this.hostname = _host;
        this.url = _url;
    }
    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
    
    public String getHostname() {
        return hostname;
    }

    public void Hostname(String hostname) {
        this.hostname = hostname;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
}
