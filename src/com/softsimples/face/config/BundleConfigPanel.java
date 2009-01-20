package com.softsimples.face.config;

public class BundleConfigPanel extends javax.swing.JPanel {

    public BundleConfigPanel() {
        this.setName("Configuração de plugins");
        initComponents();
    }

    void startOSGI() {
        this.pluginsDisponiveisPanel.start();
        this.pluginsInstaladosPanel.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        pluginsDisponiveisPanel = new com.softsimples.face.config.PluginsDisponiveisPanel();
        pluginsInstaladosPanel = new com.softsimples.face.config.PluginsInstaladosPanel();

        setOpaque(false);

        jTabbedPane1.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N

        pluginsDisponiveisPanel.setToolTipText("Plugins disponíveis");
        pluginsDisponiveisPanel.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        jTabbedPane1.addTab("Plugins disponíveis ", new javax.swing.ImageIcon(getClass().getResource("/icons/package_find.png")), pluginsDisponiveisPanel); // NOI18N

        pluginsInstaladosPanel.setToolTipText("Plugins instalados");
        pluginsInstaladosPanel.setFont(new java.awt.Font("DejaVu Sans", 1, 13)); // NOI18N
        jTabbedPane1.addTab("Plugins instalados ", new javax.swing.ImageIcon(getClass().getResource("/icons/package_view.png")), pluginsInstaladosPanel); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    private com.softsimples.face.config.PluginsDisponiveisPanel pluginsDisponiveisPanel;
    private com.softsimples.face.config.PluginsInstaladosPanel pluginsInstaladosPanel;
    // End of variables declaration//GEN-END:variables

}
