package com.softsimples.face.config;

import com.softsimples.face.config.render.PluginInstaladoRenderer;
import com.softsimples.face.model.GenericListModel;
import com.softsimples.face.resource.Resource;
import com.softsimples.face.resource.ResourceType;
import org.knopflerfish.framework.Framework;
import org.osgi.framework.Bundle;

public class PluginsInstaladosPanel extends javax.swing.JPanel {
    
    private GenericListModel<Bundle> pluginListModel;
    private PluginInstaladoRenderer pluginInstaladoRenderer;
    
    public PluginsInstaladosPanel() {
        this.setName("Plugins instalados");
        this.pluginListModel = new GenericListModel<Bundle>();
        this.pluginInstaladoRenderer = new PluginInstaladoRenderer();
        initComponents();
        
        Framework framework = Resource.get(ResourceType.OSGIFramework);
        Bundle[] bundles = framework.getSystemBundleContext().getBundles();
        for (Bundle bundle : bundles) {
            if (bundle.getBundleId() != 0) this.pluginListModel.addElement(bundle);
        }
        mainList.updateUI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mainList = new javax.swing.JList();

        mainList.setModel( this.pluginListModel);
        mainList.setCellRenderer(this.pluginInstaladoRenderer);
        jScrollPane1.setViewportView(mainList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList mainList;
    // End of variables declaration//GEN-END:variables

}
