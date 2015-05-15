package model;

import java.io.File;
import java.io.FileFilter;


/**
 * Un FilterModel filtre les types de fichiers.
 * Date : Fevrier 2015
 * @author Rija ZAFIAMY
 */

public class FilterModel {
    
    private String musicformat[];
    private String pictureformat[];
    private String documentformat[];
    private String videoformat[];
    
    public FilterModel(){
    
            musicformat = new String[]
            {
                ".3gp",".act",".aiff",".aac",".amr",".au",".awb",
                ".dct",".dss",".dvf",".flac",".gsm",".iklax",".ivs",".wv",
                ".m4a",".m4p",".mmf",".mp3",".mpc",".msv",".ogg",".oga",".webm",
                ".opus",".ra",".rm",".raw",".sln",".tta",".vox",".wav",".wma"
            };
            pictureformat = new String[]
            {
                ".jpg",".jpeg",".png",".bmp",".tiff",".svg","fpx",
                ".gif",".ico",".jp2",".nef",".orf",".pcd",".pcx",".pict",
                ".psd",".sfw","tga",".tif",".webp",".xcf"
            };
            documentformat = new String[]
            {
                ".doc",".docx",".pdf",".txt",".ppt",".pptx",
                ".csv",".ods",".xls",".xlsx",
                ".7z  ",".apk",".bz2",".gz",".gzip",".jar",
                ".rar ",".tar",".tgz ",".zip",
                ".odt",".ods",".odp",".odg",".odc",".odf",".odb",
                ".odi",".odm",".ott",".ots",".otp",".otg"
            };
            videoformat = new String[]
            {
                ".mpeg",".dat",".avi",".flv",".ogg",".mkv",".mp4",".mpeg4",
                ".3g2",".3gp",".3gpp",".asf",".divx",".f4v",".h264",
                ".ifo",".m2ts",".m4v",".mkv",".mod",".mov",".mpg",
                ".mswmm",".mts",".mxf",".ogv",".rm",".swf",".ts",".vep",
                ".vob",".webm",".wlmp",".wmv"

            };            
    }
    
    public FileFilter getFilter(String _ctg){
        
        switch(_ctg.toUpperCase()){
            case "MUSIC": return this.musicFilter();
            case "PICTURE": return this.pictureFilter();
            case "DOCUMENT": return this.documentFilter();
            case "VIDEO": return this.videoFilter();
            default:;
        }
        return null;
    }
    
    private FileFilter musicFilter(){
        
        FileFilter music = new FileFilter(){
            public boolean accept(File f){
                if(f.isFile()){
                    for(int i=0;i<musicformat.length;i++){

                        if(f.getName().toLowerCase().endsWith(musicformat[i])){
                            return true;
                        }
                    }
                }
                return false;
            }
        };
        
        return music;
    }
    
    private FileFilter pictureFilter(){
        
        FileFilter picture = new FileFilter(){
            public boolean accept(File f){
                if(f.isFile()){
                    for(int i=0;i<pictureformat.length;i++){

                        if(f.getName().toLowerCase().endsWith(pictureformat[i])){
                            return true;
                        }
                    }
                }
                return false;
            }
        };
        
        return picture;
    }
    
    private FileFilter documentFilter(){
        
        FileFilter document = new FileFilter(){
            public boolean accept(File f){
                
                if(f.isFile()){
                    for(int i=0;i<documentformat.length;i++){

                        if(f.getName().toLowerCase().endsWith(documentformat[i])){
                            return true;
                        }
                    }
                }
                return false;
            }
        };
        
        return document;
    }
    
    private FileFilter videoFilter(){
        
        FileFilter video = new FileFilter(){
            public boolean accept(File f){
                
                if(f.isFile()){
                    for(int i=0;i<videoformat.length;i++){

                        if(f.getName().toLowerCase().endsWith(videoformat[i])){
                            return true;
                        }
                    }
                }
                return false;
            }
        };
        
        return video;
    }
    
}
