package model;

/**
 * Chaque fichier dans Sharoom est classé dans 
 * une catégorie.
 * FolderCategory définit les différentes catégories.
 * Date : Fevrier 2015
 * @author Rija ZAFIAMY
 */
public enum FolderCategory {
    
    MUSIC,
    PICTURE,
    VIDEO,
    DOCUMENT;
    
    public FolderCategory getCategoryById(int id){
        
        switch(id){
            case 0: 
                return this.MUSIC;
            case 1: 
                return this.PICTURE;
            case 2: 
                return this.VIDEO;
            case 3:
                return this.DOCUMENT;
            default:return null;
        }
    }
}
