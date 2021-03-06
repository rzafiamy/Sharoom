package sharoom.view;

/**
 * Un LogPanel représente contient
 * la liste des logs sur l'interface graphique
 * Date : Fevrier 2015
 * @author Rija ZAFIAMY
 */
public class LogPanel extends javax.swing.JPanel {

    private int numero;
    private String tabTitle[];
    
    /**
     * Creates new form LogPanel
     */
    
    public LogPanel() {
        
        initComponents();
        
        numero=1;
        tabTitle = new String [] {
                "N°", "IP", "Port", "Fichier"
            };
    }

    public void addTable(Object [][] data){
      
      if(data!=null){
        this.LogTable.setModel(new javax.swing.table.DefaultTableModel(
                data,
                this.tabTitle
        ));
      }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LogLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        LogTable = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        LogLabel.setBackground(new java.awt.Color(255, 255, 255));
        LogLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LogLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sharoom/icons/log.png"))); // NOI18N
        LogLabel.setText("LOG OF FILE ACCESS");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        LogTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N°", "IP", "Port", "File"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        LogTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(LogTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LogLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogLabel;
    private javax.swing.JTable LogTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
