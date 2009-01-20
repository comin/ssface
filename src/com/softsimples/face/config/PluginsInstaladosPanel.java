package com.softsimples.face.config;

import com.softsimples.face.config.render.PluginInstaladoRendererPanel;
import com.softsimples.face.layout.VerticalLayout;
import com.softsimples.face.model.GenericListModel;
import com.softsimples.face.resource.Resource;
import com.softsimples.face.resource.ResourceType;
import java.awt.Color;
import org.knopflerfish.framework.Framework;
import org.osgi.framework.Bundle;

public class PluginsInstaladosPanel extends javax.swing.JPanel {
    
    private GenericListModel<Bundle> pluginListModel;
    
    public PluginsInstaladosPanel() {
        this.setBackground(Color.WHITE);
        this.setName("Plugins instalados");
        initComponents();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new VerticalLayout(4));
    }

    public void start() {
        Framework framework = Resource.get(ResourceType.OSGIFramework);
        Bundle[] bundles = framework.getSystemBundleContext().getBundles();
        for (Bundle bundle : bundles) {
            if (bundle.getBundleId() != 0) mainPanel.add(new PluginInstaladoRendererPanel(bundle, false, Color.WHITE));
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainPanel);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables

}
