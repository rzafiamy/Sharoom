package sharoom.view;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Un MessageDialog permet d'afficher 
 * des messages d'alerte.
 * Date : Fevrier 2015
 * @author Rija ZAFIAMY
 */
public class MessageDialog extends javax.swing.JDialog {

    /**
     * Creates new form MessageDialog
     */
    public MessageDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.pack();
    }
    
    public void alert(String _msg){
        
        this.MessageLabel.setText(_msg);
        this.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MessagePanel = new javax.swing.JPanel();
        OkButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MessageLabel = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Message");
        setMaximumSize(new java.awt.Dimension(350, 170));
        setMinimumSize(new java.awt.Dimension(350, 170));
        setPreferredSize(new java.awt.Dimension(350, 170));
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout());

        MessagePanel.setBackground(new java.awt.Color(255, 255, 255));
        MessagePanel.setMaximumSize(new java.awt.Dimension(350, 170));
        MessagePanel.setMinimumSize(new java.awt.Dimension(350, 170));
        MessagePanel.setPreferredSize(new java.awt.Dimension(350, 170));

        OkButton.setBackground(new java.awt.Color(126, 10, 10));
        OkButton.setForeground(new java.awt.Color(255, 255, 255));
        OkButton.setText("Ok");
        OkButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OkButtonMouseClicked(evt);
            }
        });

        MessageLabel.setEditable(false);
        MessageLabel.setBackground(new java.awt.Color(254, 254, 254));
        MessageLabel.setColumns(20);
        MessageLabel.setFont(new java.awt.Font("Noto Sans", 1, 10)); // NOI18N
        MessageLabel.setRows(5);
        MessageLabel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setViewportView(MessageLabel);

        javax.swing.GroupLayout MessagePanelLayout = new javax.swing.GroupLayout(MessagePanel);
        MessagePanel.setLayout(MessagePanelLayout);
        MessagePanelLayout.setHorizontalGroup(
            MessagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessagePanelLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(OkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MessagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        MessagePanelLayout.setVerticalGroup(
            MessagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MessagePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(OkButton)
                .addContainerGap())
        );

        getContentPane().add(MessagePanel);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OkButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OkButtonMouseClicked
        this.dispose();
    }//GEN-LAST:event_OkButtonMouseClicked

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea MessageLabel;
    private javax.swing.JPanel MessagePanel;
    private javax.swing.JButton OkButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
