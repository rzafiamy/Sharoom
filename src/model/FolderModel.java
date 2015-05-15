package model;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Un répertoire à laquelle on stoque des
 * fileModel indéxé par son nom. Les fileModels sont
 * indéxés par son nom dans les repertoires. 
 * Les repertoires sont quant à eux 
 * indexés par un foldercategory
 * 
 * Date : Fevrier 2015
 * @author Rija ZAFIAMY
 */

public class FolderModel {
    
    private HashMap<String,FileModel> FileList;
    private FolderCategory category;
    private int position; // pointer sur les fichiers
    
    public FolderModel(FolderCategory _ctg){
        this.category = _ctg;
        FileList = new HashMap<>();
        position = 0;
    }
    
    /**
     * Ajoute un fichier dans le repertoire.
     * @param file 
     */
    public boolean save(FileModel file){
        
        if(!this.FileList.containsKey(file.getName()))
        {
            this.FileList.put(file.getName(), file);
            return true;
        }
        
        return false;
    }
    
    /**
     * Recherche un fichier dans le repertoire.
     * @param _fname
     * @return 
     */
    public FileModel find(String _fname){
        
            if(this.FileList.containsKey(_fname)){
                return this.FileList.get(_fname);
            }
            return null;
    }
   
    /**
     * Vérifie si un fichier existe dans le dossier
     * @param _fname
     * @return 
     */
    public boolean checkIfExist(String _fname){
        
            if(this.FileList.containsKey(_fname)){
                return true;
            }
            return false;
    }
    
    /**
     * Recherche un fichier en fonction de son id
     * dans le folderModel
     * @param index
     * @return 
     */
    public FileModel find2(int index){
        
        
        if(this.fetchAllToHashMap2().containsKey(index)){
            return this.fetchAllToHashMap2().get(index);
        }
        
        return null;
    }
    /**
     * Supprime un fichier du repertoire.
     * @param _fname 
     */
    public void delete(String _fname){
        
        if(find(_fname)!=null){
            this.FileList.remove(_fname);
        }
    }
    
    /**
     * Supprime tous les fichiers du repertoire
     */
    public void deleteAll(){
            this.FileList.clear();
    }
    
    /**
     * Recupère la liste des fichiers indexé par nom
     * @return 
     */
    public HashMap <String, FileModel> fetchAllToHashMap() {
        return FileList;
    }
    /**
     * Recupère la liste des fichiers indexé par un entier
     * @return 
     */
    public HashMap<Integer,FileModel> fetchAllToHashMap2(){
        
        int i=0;
        
        HashMap<Integer,FileModel> liste = new HashMap<>();
        
        for (String key: this.FileList.keySet()) {

            liste.put(i,this.FileList.get(key));
            
            i++;
        }        
        
        return liste;
    }
    
    /**
     * Récupère une liste de fichier.
     * @return 
     */
    public ArrayList<FileModel> fetchAllToArray(){
        
        ArrayList<FileModel> liste = new ArrayList<>();
           
        for (String key: this.FileList.keySet()) {

            liste.add(this.FileList.get(key));
        }
        
        return liste;
    }
            
    public FolderCategory getCategory() {
        return category;
    }

    public void setCategory(FolderCategory category) {
        this.category = category;
    }

    /**
     * Récupère le nombre de fichier stocké
     * @return 
     */
    public int getNumFile(){
        return this.FileList.size();
    }
    
}
