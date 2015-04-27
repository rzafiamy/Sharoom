package model;

/**
 * Un FileModel est un modèle de fichier.
 * Chaque fichier dans Sharoom est un filemodel
 * Date : Fevrier 2015
 * @author Rija ZAFIAMY
 */

public class FileModel {
 
    // Attributs
    private long size;
    private String name;
    private String type;
    private String absolutePath;
    private boolean isShared;
            
    public FileModel(String _name,String _absPath,long _size){
        this.name = _name;
        this.absolutePath = _absPath;
        this.size = _size;        
        this.type = this.getTypeFromName(_name);
    }
    
    public FileModel(String _name,String _absPath,int _size,boolean _isShared){
        this.name = _name;
        this.absolutePath = _absPath;
        this.size = _size;
        this.isShared = _isShared;
        this.type = this.getTypeFromName(_name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public boolean isIsShared() {
        return isShared;
    }

    public void setIsShared(boolean isShared) {
        this.isShared = isShared;
    }
    
    // File Operation
    public void renameFile(String _newName){
        this.name = _newName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
 
    public String getTypeFromName(String _name){
        

        int pos = _name.lastIndexOf(".");
       
        if(pos!=-1){
            return _name.substring(pos+1);
        }
        return "txt";
    }
}
