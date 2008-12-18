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

        pluginsDisponiveisPanel.setToolTipText("Plugins disponiveis");
        jTabbedPane1.addTab("Plugins disponiveis", pluginsDisponiveisPanel);

        pluginsInstaladosPanel.setToolTipText("Plugins instalados");
        jTabbedPane1.addTab("Plugins instalados", pluginsInstaladosPanel);

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
