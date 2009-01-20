package com.softsimples.face.config;

import com.softsimples.face.config.render.PluginDisponivelRendererPanel;
import com.softsimples.face.domain.SitePlugin;
import com.softsimples.face.domain.SiteUpdate;
import com.softsimples.face.layout.VerticalLayout;
import com.softsimples.face.resource.Resource;
import com.softsimples.face.resource.ResourceType;
import java.awt.Color;
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
    }

    public void start() {
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
            List<SitePlugin> plugins = SiteUpdate.getPluginsDisponiveis("http://www.softsimples.com.br/plugin/todosOsPlugins");
            for (SitePlugin sitePlugin: plugins) {
                if (!jaEstaInstalado(sitePlugin)) {
                    mainPanel.add(new PluginDisponivelRendererPanel(sitePlugin, false, Color.WHITE));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(PluginsDisponiveisPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean jaEstaInstalado(SitePlugin sitePlugin) {
        boolean retorno = false;
        for (int i = 0; i < instalados.length; i++) {
            Bundle bundle = instalados[i];
            String symbolicName;
            symbolicName = sitePlugin.getNomeSimbolico();
            if (bundle.getSymbolicName().equals(symbolicName)) {
                retorno = true;
                break;
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
