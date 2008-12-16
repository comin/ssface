package com.softsimples.face.config;

import com.softsimples.face.config.render.PluginDisponivelRendererPanel;
import com.softsimples.face.domain.SiteUpdate;
import com.softsimples.face.file.PluginWrapper;
import com.softsimples.face.layout.VerticalLayout;
import com.softsimples.face.resource.Resource;
import com.softsimples.face.resource.ResourceType;
import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import org.knopflerfish.framework.Framework;
import org.osgi.framework.Bundle;

public class PluginsDisponiveisPanel extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;
    private Bundle[] instalados;

  
    public PluginsDisponiveisPanel() {
        this.setBackground(Color.WHITE);
        this.setName("Plugins disponíveis");
        initComponents();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new VerticalLayout(4));
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                recuperarInstalados();
                carregarPlugins();
            }
        });
    }
    
    public void recuperarInstalados() {
        Framework framework = Resource.get(ResourceType.OSGIFramework);
        instalados = framework.getSystemBundleContext().getBundles();
    }
    public void carregarPlugins() {
        try {
            List<PluginWrapper> plugins = SiteUpdate.getPluginsDisponiveis(new URL("http://www.softsimples.com/plugins"));
            for (PluginWrapper pluginWrapper : plugins) {
                if (!jaEstaInstalado(pluginWrapper)) {
                    mainPanel.add(new PluginDisponivelRendererPanel(pluginWrapper, false, Color.WHITE));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PluginsDisponiveisPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean jaEstaInstalado(PluginWrapper pluginWrapper) {
        boolean retorno = false;
        for (int i = 0; i < instalados.length; i++) {
            Bundle bundle = instalados[i];
            String symbolicName;
            try {
                symbolicName = pluginWrapper.getManifest().bundleSymbolicName();
                if (bundle.getSymbolicName().equals(symbolicName)) {
                    retorno = true;
                    break;
                }
            } catch (IOException ex) {
                Logger.getLogger(PluginsDisponiveisPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retorno;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainScrollPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 219, Short.MAX_VALUE)
        );

        mainScrollPane.setViewportView(mainPanel);

        add(mainScrollPane, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane mainScrollPane;
    // End of variables declaration//GEN-END:variables

}
