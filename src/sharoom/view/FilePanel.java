package sharoom.view;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Un FilePanel représente un fichier
 * sur l'interface graphique
 * Date : Fevrier 2015
 * @author Rija ZAFIAMY
 */
public class FilePanel extends javax.swing.JPanel{
    
    /**
     * Creates new form FilePanel
     */
    public FilePanel(SharoomGUI _parent) {
        initComponents();
        this.parentPanel = _parent;
        onMouseOverColor = new Color(255,203,88);
        defaultColor = new Color(224,255,235);
        onClickColor = new Color(59,130,157);
    }

    public FilePanel(SharoomGUI _parent, String _filename){
        initComponents();
        this.parentPanel = _parent;
        this.FilenameField.setText(_filename);
    }
    
    public void InterfaceSuppression(){
        this.setBackground(new java.awt.Color(99,99,99));
    }
    
    public String getFileName(){
        
        return this.FilenameField.getText();
    }
    
    public void FocusTextField(){
        this.FilenameField.setEditable(true);
        this.FilenameField.setBorder(new javax.swing.border.LineBorder(Color.yellow));
        this.FilenameField.setFocusCycleRoot(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        FilenameField = new javax.swing.JTextField();
        DeleteButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(254, 254, 254));
        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        setMaximumSize(new java.awt.Dimension(32767, 30));
        setMinimumSize(new java.awt.Dimension(100, 30));
        setPreferredSize(new java.awt.Dimension(400, 30));
        setLayout(new java.awt.GridBagLayout());

        FilenameField.setEditable(false);
        FilenameField.setBackground(new java.awt.Color(254, 254, 254));
        FilenameField.setFont(new java.awt.Font("Noto Sans", 1, 12)); // NOI18N
        FilenameField.setText("Filename.txt");
        FilenameField.setBorder(null);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        add(FilenameField, gridBagConstraints);

        DeleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sharoom/icons/blue_theme/delete.gif"))); // NOI18N
        DeleteButton.setBorder(null);
        DeleteButton.setMaximumSize(new java.awt.Dimension(40, 40));
        DeleteButton.setMinimumSize(new java.awt.Dimension(40, 40));
        DeleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteButtonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        add(DeleteButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteButtonMouseClicked
        this.parentPanel.DeleteFileGUI(this);
    }//GEN-LAST:event_DeleteButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField FilenameField;
    // End of variables declaration//GEN-END:variables
    
    // Attributs
    private SharoomGUI parentPanel;
    private Color onMouseOverColor;
    private Color defaultColor;
    private Color onClickColor;
}
