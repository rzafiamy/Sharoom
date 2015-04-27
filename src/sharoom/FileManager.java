package sharoom;
import java.io.File;
import model.*;

/**
 * Un FileManager permet de charger ,
 * supprimer une liste de fichier. 
 * FileManager est une interface entre le système
 * de fichier réel (File) et celui virtuel FileModel.
 * Date : Fevrier 2015
 * @author Rija ZAFIAMY
 */

public class FileManager {
    
    private FolderModel [] folder;
    
    public FileManager(){
        folder = new FolderModel[4];
        initFolder();
    }
    
    private void initFolder(){
        
        folder[0] = new FolderModel(FolderCategory.MUSIC);
        folder[1] = new FolderModel(FolderCategory.PICTURE);
        folder[2] = new FolderModel(FolderCategory.VIDEO);
        folder[3] = new FolderModel(FolderCategory.DOCUMENT);
    }
    
    /**
     * Charge des fichiers dans Sharoom et retourne
     * le nombre de fichier chargé.
     * @param fileList
     * @param ctg 
     */
    public int Upload(File[] fileList,String ctg){
        
        if(fileList!=null){
            // music category
            if(ctg.compareTo(FolderCategory.MUSIC.toString())==0){
                
                // convertir file en filemodel et stocke dans un foldermodel
                for(int i=0;i<fileList.length;i++){
                    
                    FileModel f = new FileModel(fileList[i].getName(),
                                                fileList[i].getAbsolutePath(),
                                                fileList[i].length());
                    folder[0].save(f);
                }
                
                return folder[0].getNumFile();
            }
            // picture category
            else if(ctg.compareTo(FolderCategory.PICTURE.toString())==0){
                
                // convertir file en filemodel et stocke dans un foldermodel
                for(int i=0;i<fileList.length;i++){
                    FileModel f = new  FileModel(fileList[i].getName(),
                                                fileList[i].getAbsolutePath(),
                                                fileList[i].length());
                    folder[1].save(f);
                }
                return folder[1].getNumFile();
            }            
            // video category
            else if(ctg.compareTo(FolderCategory.VIDEO.toString())==0){
                
                // convertir file en filemodel et stocke dans un foldermodel
                for(int i=0;i<fileList.length;i++){
                     FileModel f = new  FileModel(fileList[i].getName(),
                                                fileList[i].getAbsolutePath(),
                                                fileList[i].length());
                    folder[2].save(f);
                }
                return folder[2].getNumFile();
            }            
            // document category
            else if(ctg.compareTo(FolderCategory.DOCUMENT.toString())==0){
                
                for(int i=0;i<fileList.length;i++){
                     FileModel f = new  FileModel(fileList[i].getName(),
                                                fileList[i].getAbsolutePath(),
                                                fileList[i].length());
                    folder[3].save(f);
                }
                return folder[3].getNumFile();
            }
        }
        
        return 0;
    }

    /**
     * Télécharge des fichiers depuis un repertoire
     * @param _ctg
     * @return 
     */
    public FolderModel Download(String _ctg){
        
               // music category
       if(_ctg.compareTo(FolderCategory.MUSIC.toString())==0){
           return this.folder[0];
       }
       // picture category
       else if(_ctg.compareTo(FolderCategory.PICTURE.toString())==0){
           return this.folder[1];
       }
      // video category
      else if(_ctg.compareTo(FolderCategory.VIDEO.toString())==0){
         return this.folder[2];
      }
        // document category
      else if(_ctg.compareTo(FolderCategory.DOCUMENT.toString())==0){
          return this.folder[3];
      }
       
       return null;
    }
    
    /**
     * Supprime les filemodel dans un foldersmodel
     * @param ctg 
     */
    public void DeleteAllFileInFolderModel(String ctg){
        
       // music category
       if(ctg.compareTo(FolderCategory.MUSIC.toString())==0){
           this.folder[0].deleteAll();
       }
       // picture category
       else if(ctg.compareTo(FolderCategory.PICTURE.toString())==0){
           this.folder[1].deleteAll();
       }
      // video category
      else if(ctg.compareTo(FolderCategory.VIDEO.toString())==0){
          this.folder[2].deleteAll();
      }
        // document category
      else if(ctg.compareTo(FolderCategory.DOCUMENT.toString())==0){
          this.folder[3].deleteAll();
      }
    }
    
    /**
     * Supprime un filemodel d'une categorie de foldermodel
     * @param _fname
     * @param _ctg 
     */
    public void DeleteFile(String _fname,String _ctg){
        
        // music category
       if(_ctg.compareTo(FolderCategory.MUSIC.toString())==0){
           this.folder[0].delete(_fname);
       }
       // picture category
       else if(_ctg.compareTo(FolderCategory.PICTURE.toString())==0){
           this.folder[1].delete(_fname);
       }
      // video category
      else if(_ctg.compareTo(FolderCategory.VIDEO.toString())==0){
          this.folder[2].delete(_fname);
      }
        // document category
      else if(_ctg.compareTo(FolderCategory.DOCUMENT.toString())==0){
          this.folder[3].delete(_fname);
      }
    }
       
    /**
     * Nombre de fichier dans la catégorie
     * @param ctg
     * @return 
     */
    public int FileNum(String _ctg){
        // music category
       if(_ctg.compareTo(FolderCategory.MUSIC.toString())==0){
           return this.folder[0].getNumFile();
       }
       // picture category
       else if(_ctg.compareTo(FolderCategory.PICTURE.toString())==0){
           return this.folder[1].getNumFile();
       }
      // video category
      else if(_ctg.compareTo(FolderCategory.VIDEO.toString())==0){
          return this.folder[2].getNumFile();
      }
        // document category
      else if(_ctg.compareTo(FolderCategory.DOCUMENT.toString())==0){
          return this.folder[3].getNumFile();
      }
      
       return 0;
    }
}
