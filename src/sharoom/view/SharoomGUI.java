package sharoom.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.*;
import sharoom.FileManager;
import sharoom.LogManager;
import sharoom.ServerHTTP;

/**
 * SharoomGUI est l'interface principale
 * de Sharoom.
 * Date : Fevrier 2015
 * @author Rija ZAFIAMY
 */
public class SharoomGUI extends javax.swing.JFrame {

    /**
     * Creates new form SharoomGUI
     */
    public SharoomGUI() {
        
        // Views
        initComponents();
        
        // Log panel
        LogPanel logPanel= new LogPanel();
        ContentPanel.add(logPanel, java.awt.BorderLayout.LINE_END);
        
       // Category FileboxPanel
        idCurrentCategory = 0;
        FileBoxPanel = new javax.swing.JPanel[4];
        FileBoxScrollPane = new javax.swing.JScrollPane[4];
        initPanelGUI();
        
        // Controllers
        filecontroller = new FileManager();
        
        // variables
        this.isRunned = false;
        this.config = new Config();
        
        // Align Jframe
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        
        // Log Manager
        this.logmanager     = new LogManager(logPanel);
        
        // Filtre
        filtermodel         = new FilterModel();
        
        // Dialog config
        this.configDialog   = new ConfigurationDialog(this,true,this.config);
        
        compteurConfig      = 0;
    }
    /*
     * Delete file from GUI
     */
    public void DeleteFileGUI(FilePanel file){
        
        // controller
        this.filecontroller.DeleteFile(this.CurrentCategoryLabel.getText(),file.getFileName());
        this.server.deleteSharedFile(this.CurrentCategoryLabel.getText(),file.getFileName());
        //view
        this.FileBoxPanel[idCurrentCategory].remove(file);
        this.FileBoxPanel[idCurrentCategory].updateUI();
    }
    /**
     * Rename file from GUI
     * @param file 
     */
    public void RenameFileGUI(FilePanel file){
        
        file.FocusTextField();
    }
    /**
     * Add new file on GUI from Jfilechooser
     * @param file 
     */
    public void AddFileGUI(FilePanel file){
        
        this.FileBoxPanel[idCurrentCategory].add(file);
        this.FileBoxPanel[idCurrentCategory].updateUI();
    }
    
    /**
     * Add new folder on GUI from Jfilechooser
     * @param folder
     */
    public void AddFolderGUI(FolderPanel folder){
        
        this.FileBoxPanel[idCurrentCategory].add(folder);
        this.FileBoxPanel[idCurrentCategory].updateUI();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        BannerPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        FooterPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        ShareBoxPanel = new javax.swing.JPanel();
        MusicButton = new javax.swing.JButton();
        PictureButton = new javax.swing.JButton();
        VideoButton = new javax.swing.JButton();
        DocumentButton = new javax.swing.JButton();
        ContentPanel = new javax.swing.JPanel();
        HeadPanel = new javax.swing.JPanel();
        CurrentCategoryLabel = new javax.swing.JLabel();
        FileUploaderPanel = new javax.swing.JPanel();
        UploadFileButton = new javax.swing.JButton();
        FileBoxMainPanel = new javax.swing.JPanel();
        ActionPanel = new javax.swing.JPanel();
        StartButton = new javax.swing.JButton();
        DeleteAllButton = new javax.swing.JButton();
        SharoomMenuBar = new javax.swing.JMenuBar();
        MenuFile = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();
        MenuTools = new javax.swing.JMenu();
        jMenuItemShowConfiguration = new javax.swing.JMenuItem();
        jMenuItemAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SHAROOM");
        setPreferredSize(new java.awt.Dimension(1024, 768));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        MainPanel.setBackground(new java.awt.Color(51, 51, 51));
        MainPanel.setMinimumSize(new java.awt.Dimension(400, 300));
        MainPanel.setLayout(new java.awt.BorderLayout(5, 5));

        BannerPanel.setLayout(new javax.swing.BoxLayout(BannerPanel, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sharoom/icons/banner.gif"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(800, 100));
        BannerPanel.add(jLabel1);

        MainPanel.add(BannerPanel, java.awt.BorderLayout.PAGE_START);

        FooterPanel.setMaximumSize(new java.awt.Dimension(32767, 30));
        FooterPanel.setMinimumSize(new java.awt.Dimension(100, 30));
        FooterPanel.setPreferredSize(new java.awt.Dimension(400, 30));
        FooterPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sous licence GPL v3");
        FooterPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 7, -1, -1));
        FooterPanel.add(jLabelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 520, 20));

        MainPanel.add(FooterPanel, java.awt.BorderLayout.PAGE_END);

        ShareBoxPanel.setBackground(new java.awt.Color(51, 51, 51));
        ShareBoxPanel.setPreferredSize(new java.awt.Dimension(200, 160));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout();
        flowLayout1.setAlignOnBaseline(true);
        ShareBoxPanel.setLayout(flowLayout1);

        MusicButton.setBackground(new java.awt.Color(51, 0, 51));
        MusicButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        MusicButton.setForeground(new java.awt.Color(255, 255, 255));
        MusicButton.setText("MUSIC");
        MusicButton.setMinimumSize(new java.awt.Dimension(116, 75));
        MusicButton.setPreferredSize(new java.awt.Dimension(200, 70));
        MusicButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MusicButtonMouseClicked(evt);
            }
        });
        ShareBoxPanel.add(MusicButton);

        PictureButton.setBackground(new java.awt.Color(0, 51, 51));
        PictureButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        PictureButton.setForeground(new java.awt.Color(255, 255, 255));
        PictureButton.setText("PICTURE");
        PictureButton.setPreferredSize(new java.awt.Dimension(200, 70));
        PictureButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PictureButtonMouseClicked(evt);
            }
        });
        ShareBoxPanel.add(PictureButton);

        VideoButton.setBackground(new java.awt.Color(51, 51, 0));
        VideoButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        VideoButton.setForeground(new java.awt.Color(255, 255, 255));
        VideoButton.setText("VIDEO");
        VideoButton.setPreferredSize(new java.awt.Dimension(200, 70));
        VideoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                VideoButtonMouseClicked(evt);
            }
        });
        ShareBoxPanel.add(VideoButton);

        DocumentButton.setBackground(new java.awt.Color(51, 51, 51));
        DocumentButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        DocumentButton.setForeground(new java.awt.Color(255, 255, 255));
        DocumentButton.setText("DOCUMENT");
        DocumentButton.setPreferredSize(new java.awt.Dimension(200, 70));
        DocumentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DocumentButtonMouseClicked(evt);
            }
        });
        ShareBoxPanel.add(DocumentButton);

        MainPanel.add(ShareBoxPanel, java.awt.BorderLayout.LINE_START);

        ContentPanel.setBackground(new java.awt.Color(0, 0, 0));
        ContentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        ContentPanel.setLayout(new java.awt.BorderLayout());

        HeadPanel.setBackground(new java.awt.Color(255, 255, 255));
        HeadPanel.setMaximumSize(new java.awt.Dimension(32767, 40));
        HeadPanel.setMinimumSize(new java.awt.Dimension(100, 40));
        HeadPanel.setPreferredSize(new java.awt.Dimension(195, 50));
        HeadPanel.setLayout(new java.awt.GridLayout(1, 0));

        CurrentCategoryLabel.setBackground(new java.awt.Color(255, 255, 255));
        CurrentCategoryLabel.setFont(new java.awt.Font("Aegean", 1, 18)); // NOI18N
        CurrentCategoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CurrentCategoryLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sharoom/icons/music.png"))); // NOI18N
        CurrentCategoryLabel.setText("MUSIC");
        CurrentCategoryLabel.setOpaque(true);
        CurrentCategoryLabel.setPreferredSize(new java.awt.Dimension(120, 40));
        HeadPanel.add(CurrentCategoryLabel);

        FileUploaderPanel.setBackground(new java.awt.Color(255, 255, 255));
        FileUploaderPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        UploadFileButton.setBackground(new java.awt.Color(195, 195, 195));
        UploadFileButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        UploadFileButton.setForeground(new java.awt.Color(5, 0, 0));
        UploadFileButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sharoom/icons/upload.png"))); // NOI18N
        UploadFileButton.setText("Upload files");
        UploadFileButton.setPreferredSize(new java.awt.Dimension(150, 40));
        UploadFileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UploadFileButtonMouseClicked(evt);
            }
        });
        UploadFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UploadFileButtonActionPerformed(evt);
            }
        });
        FileUploaderPanel.add(UploadFileButton);

        HeadPanel.add(FileUploaderPanel);

        ContentPanel.add(HeadPanel, java.awt.BorderLayout.NORTH);

        FileBoxMainPanel.setLayout(new java.awt.CardLayout());
        ContentPanel.add(FileBoxMainPanel, java.awt.BorderLayout.CENTER);

        ActionPanel.setBackground(new java.awt.Color(255, 255, 255));
        ActionPanel.setMaximumSize(new java.awt.Dimension(32767, 50));
        ActionPanel.setMinimumSize(new java.awt.Dimension(100, 50));
        ActionPanel.setPreferredSize(new java.awt.Dimension(195, 50));

        StartButton.setBackground(new java.awt.Color(26, 160, 73));
        StartButton.setForeground(new java.awt.Color(255, 255, 255));
        StartButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sharoom/icons/start.png"))); // NOI18N
        StartButton.setText("Start");
        StartButton.setPreferredSize(new java.awt.Dimension(150, 40));
        StartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StartButtonMouseClicked(evt);
            }
        });
        ActionPanel.add(StartButton);

        DeleteAllButton.setBackground(new java.awt.Color(127, 2, 2));
        DeleteAllButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteAllButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sharoom/icons/delete.png"))); // NOI18N
        DeleteAllButton.setText("Delete all");
        DeleteAllButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteAllButtonMouseClicked(evt);
            }
        });
        DeleteAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteAllButtonActionPerformed(evt);
            }
        });
        ActionPanel.add(DeleteAllButton);

        ContentPanel.add(ActionPanel, java.awt.BorderLayout.SOUTH);

        MainPanel.add(ContentPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(MainPanel);

        SharoomMenuBar.setBackground(new java.awt.Color(0, 0, 0));
        SharoomMenuBar.setForeground(new java.awt.Color(255, 255, 255));

        MenuFile.setForeground(new java.awt.Color(255, 255, 255));
        MenuFile.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Open");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MenuFile.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Save");
        MenuFile.add(jMenuItem2);

        jMenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        MenuFile.add(jMenuItemExit);

        SharoomMenuBar.add(MenuFile);

        MenuTools.setForeground(new java.awt.Color(255, 255, 255));
        MenuTools.setText("Tools");

        jMenuItemShowConfiguration.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        jMenuItemShowConfiguration.setText("Configuration");
        jMenuItemShowConfiguration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemShowConfigurationActionPerformed(evt);
            }
        });
        MenuTools.add(jMenuItemShowConfiguration);

        jMenuItemAbout.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemAbout.setText("About");
        jMenuItemAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAboutActionPerformed(evt);
            }
        });
        MenuTools.add(jMenuItemAbout);

        SharoomMenuBar.add(MenuTools);

        setJMenuBar(SharoomMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void UploadFileButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UploadFileButtonMouseClicked
       
        if(isRunned)
        {
            
            int compteurDoublon = 0;
            
            FileUploadChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
            
            int retour = FileUploadChooser.showOpenDialog(this);
            
            if(retour == javax.swing.JFileChooser.APPROVE_OPTION){
               int i=0;
               
                // des fichiers ont été choisis 
               // (sortie par OK)
               java.io.File dir=FileUploadChooser.getSelectedFile();
               
               //File [] fs = dir.listFiles(filtermodel.getFilter(this.CurrentCategoryLabel.getText()));
               HashMap<String,String> lfile = new HashMap<String,String>();
               
               
               
               filecontroller.findAllCtgFiles(lfile,dir.getAbsolutePath(),this.CurrentCategoryLabel.getText());
               
               
              // FolderPanel fpanel = new FolderPanel(dir.getAbsolutePath());
               
               for(Map.Entry<String,String> entry : lfile.entrySet())
               { 
                     if(!filecontroller.checkIfExist(entry.getKey(), this.CurrentCategoryLabel.getText()))
                       {
                        this.AddFileGUI(new FilePanel(this,entry.getKey()));
                        i++;
                       }
                       else
                       {
                           compteurDoublon++;
                       }
               }
               
                // save uploaded file(s) in model
               filecontroller.Upload(lfile,this.CurrentCategoryLabel.getText());
               String ctg = new String(this.CurrentCategoryLabel.getText().toUpperCase());
               this.server.initSharedFile(ctg,this.filecontroller.Download(ctg));

               // Affiche un message
               if(compteurDoublon==0)
               {
                    this.messageDialog.alert(i+" file(s) added successfully !");
               }
               else
               {
                   this.messageDialog.alert(compteurDoublon+" file(s) already exist and not added!");
               }
            }
        }
        else{
            this.messageDialog.alert("Please, check wether server is running correctly. \nOtherwise click on start button.");
        }
    }//GEN-LAST:event_UploadFileButtonMouseClicked

    private void MusicButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MusicButtonMouseClicked
       this.CurrentCategoryLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sharoom/icons/music.png")));
       this.CurrentCategoryLabel.setText("MUSIC");
       this.idCurrentCategory = 0;
       java.awt.CardLayout c = (java.awt.CardLayout)this.FileBoxMainPanel.getLayout();
       c.show(this.FileBoxMainPanel,"box0");
    }//GEN-LAST:event_MusicButtonMouseClicked

    private void PictureButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PictureButtonMouseClicked
        this.CurrentCategoryLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sharoom/icons/picture.png")));
        this.CurrentCategoryLabel.setText("PICTURE");
        this.idCurrentCategory = 1;
        java.awt.CardLayout c = (java.awt.CardLayout)this.FileBoxMainPanel.getLayout();
       c.show(this.FileBoxMainPanel,"box1");
    }//GEN-LAST:event_PictureButtonMouseClicked

    private void VideoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VideoButtonMouseClicked
        this.CurrentCategoryLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sharoom/icons/video.png")));
        this.CurrentCategoryLabel.setText("VIDEO");
        this.idCurrentCategory = 2;
        java.awt.CardLayout c = (java.awt.CardLayout)this.FileBoxMainPanel.getLayout();
       c.show(this.FileBoxMainPanel,"box2");        
    }//GEN-LAST:event_VideoButtonMouseClicked

    private void DocumentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DocumentButtonMouseClicked
        this.CurrentCategoryLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sharoom/icons/document.png")));
        this.CurrentCategoryLabel.setText("DOCUMENT");
        this.idCurrentCategory = 3;
        java.awt.CardLayout c = (java.awt.CardLayout)this.FileBoxMainPanel.getLayout();
       c.show(this.FileBoxMainPanel,"box3");
    }//GEN-LAST:event_DocumentButtonMouseClicked

    private void StartButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartButtonMouseClicked
        
        
        if(0 == this.compteurConfig)
        {
            this.messageDialog.alert("Listening on :\n"+this.config.getConfigVariable("IP")+":"+this.config.getConfigVariable("PORT"));
            this.compteurConfig = 1;
        }
        if(!isRunned){
            this.server = new ServerHTTP(this.config);
            this.server.setLogManager(logmanager);
            
            this.server.start();
            this.isRunned = true;
            this.StartButton.setLabel("Stop");
        }
        else{
            this.server.kill();
            this.isRunned = false;
            this.StartButton.setLabel("Start");
        }
        
    }//GEN-LAST:event_StartButtonMouseClicked

    private void DeleteAllButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteAllButtonMouseClicked
        
        // clear view
        this.FileBoxPanel[this.idCurrentCategory].removeAll();
        this.FileBoxPanel[this.idCurrentCategory].updateUI();
        // clear model 
        this.filecontroller.DeleteAllFileInFolderModel(this.CurrentCategoryLabel.getText());
        this.server.deleteAllSharedFile(this.CurrentCategoryLabel.getText().toUpperCase());
        // message
        this.messageDialog.alert(this.CurrentCategoryLabel.getText()+":All files are deleted!");
        
    }//GEN-LAST:event_DeleteAllButtonMouseClicked

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        
        if(isRunned){
            this.server.kill();
            this.isRunned = false;
            this.StartButton.setLabel("Start");
        }
        
        this.dispose();
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jMenuItemShowConfigurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemShowConfigurationActionPerformed
        
        this.configDialog.setVisible(true);
    }//GEN-LAST:event_jMenuItemShowConfigurationActionPerformed

    private void jMenuItemAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAboutActionPerformed
       
        String about =  "   Sharoom is used for sharing files between computer \n";
               about += "   and any other devices with web browser. This app. was \n";
               about += "   developped in JAVA and runs as a web server.\n";
               about += "   Remote clients get easily access on shared files.\n";
               about += "   It is light, simple to use and ready to apply without \n";
               about += "   any configurations. Just upload and share !\n";
               about +=" \n";
               about +="        Author: Rija ZAFIAMY\n";
               about +="        rija.tgv.enisr@gmail.com\n";
               
        this.infosDialog.infos(about);
    }//GEN-LAST:event_jMenuItemAboutActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void DeleteAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteAllButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteAllButtonActionPerformed

    private void UploadFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UploadFileButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UploadFileButtonActionPerformed

    private void initPanelGUI(){
         // Message Dialog
        this.messageDialog = new MessageDialog(this,true);
        // Infos Dialog
        this.infosDialog = new InfosDialog(this,true);
        
        // Filechooser
        this.FileUploadChooser = new javax.swing.JFileChooser();
        this.FileUploadChooser.setMultiSelectionEnabled(true);
        
        // Music, Picture, Video, Document Panels
        
        for(int i=0;i<4;i++){
            this.FileBoxPanel[i] = new javax.swing.JPanel();
            this.FileBoxPanel[i].setLayout(
                new javax.swing.BoxLayout(
                    this.FileBoxPanel[i], javax.swing.BoxLayout.Y_AXIS
                )
            );
            this.FileBoxScrollPane[i] = new javax.swing.JScrollPane();
            this.FileBoxScrollPane[i].getViewport().add(this.FileBoxPanel[i]);
            this.FileBoxScrollPane[i].getVerticalScrollBar().setUnitIncrement(15);
            this.FileBoxScrollPane[i].setBorder(new javax.swing.border.EmptyBorder(0,0,0,0));
            // add panel into the layout
            this.FileBoxMainPanel.add(this.FileBoxScrollPane[i],"box"+i);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ActionPanel;
    private javax.swing.JPanel BannerPanel;
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JLabel CurrentCategoryLabel;
    private javax.swing.JButton DeleteAllButton;
    private javax.swing.JButton DocumentButton;
    private javax.swing.JPanel FileBoxMainPanel;
    private javax.swing.JPanel FileUploaderPanel;
    private javax.swing.JPanel FooterPanel;
    private javax.swing.JPanel HeadPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JMenu MenuFile;
    private javax.swing.JMenu MenuTools;
    private javax.swing.JButton MusicButton;
    private javax.swing.JButton PictureButton;
    private javax.swing.JPanel ShareBoxPanel;
    private javax.swing.JMenuBar SharoomMenuBar;
    private javax.swing.JButton StartButton;
    private javax.swing.JButton UploadFileButton;
    private javax.swing.JButton VideoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemAbout;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemShowConfiguration;
    // End of variables declaration//GEN-END:variables

    // Attributs
    private int idCurrentCategory;
    private int compteurConfig;
    private javax.swing.JPanel [] FileBoxPanel;
    private javax.swing.JScrollPane []FileBoxScrollPane;
    private javax.swing.JFileChooser FileUploadChooser;
    private MessageDialog messageDialog;
    private InfosDialog infosDialog;
    private ConfigurationDialog configDialog;
    private FileManager filecontroller;
    private boolean isRunned;
    private Config config;
    private ServerHTTP server;
    private LogManager logmanager;
    private FilterModel filtermodel;
    
    
}
