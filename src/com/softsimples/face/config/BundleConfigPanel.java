package com.softsimples.face.config;

import com.softsimples.face.util.UtilIcons;

public class BundleConfigPanel extends javax.swing.JPanel {

    public BundleConfigPanel() {
        this.setName("Configuração de plugins");
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainTabbedPane = new javax.swing.JTabbedPane();
        pluginsDisponiveis2Panel1 = new com.softsimples.face.config.PluginsDisponiveisPanel();
        pluginsInstaladosPanel = new com.softsimples.face.config.PluginsInstaladosPanel();

        setOpaque(false);

        mainTabbedPane.addTab("Plugins disponíveis ", UtilIcons.findBundleIcon(), pluginsDisponiveis2Panel1, "");
        mainTabbedPane.addTab("Plugins instalados ", UtilIcons.instaledBundleIcon(), pluginsInstaladosPanel, "");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane mainTabbedPane;
    private com.softsimples.face.config.PluginsDisponiveisPanel pluginsDisponiveis2Panel1;
    private com.softsimples.face.config.PluginsInstaladosPanel pluginsInstaladosPanel;
    // End of variables declaration//GEN-END:variables

}
