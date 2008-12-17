package com.softsimples.face;

import com.softsimples.face.resource.Resource;
import com.softsimples.face.resource.ResourceType;
import com.softsimples.face.services.MenuPrincipalService;
import com.softsimples.face.services.MenuPrincipalServiceImpl;
import com.softsimples.ui.base.CloseWindowListener;
import com.softsimples.ui.base.OpenWindowListener;
import com.softsimples.ui.base.OverlayPanel;
import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.BorderLayout;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.jdesktop.jxlayer.JXLayer;
import org.knopflerfish.framework.Framework;
import org.osgi.framework.BundleContext;

public class SoftSimplesUI extends javax.swing.JApplet implements OpenWindowListener, CloseWindowListener {
    private static final long serialVersionUID = 1L;
    private JXLayer layer;
    private SoftSimplesMenu softSimplesMenu;
    private JComponent defaultGlassPane;
    
    @Override
    public void init() {
        setLookAndFeel();
        softSimplesMenu = new SoftSimplesMenu(this, "/background/fundo2.jpg");
        layer = new JXLayer(this.softSimplesMenu);
        defaultGlassPane = this.layer.getGlassPane();
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    loadOSGIFramework();
                    initComponents();
                    softSimplesMenu.executar();
                    add(layer, BorderLayout.CENTER);
                    
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SoftSimplesUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadOSGIFramework() {
        try {
            Framework framework = OSGIFramework.getFramework();
            BundleContext bundleContext = framework.getSystemBundleContext();
            bundleContext.registerService(MenuPrincipalService.class.getName(), new MenuPrincipalServiceImpl(softSimplesMenu), new Properties());
            framework.launch(0);
            Resource.add(ResourceType.OSGIFramework, framework);
        } catch (Exception ex) {
            Logger.getLogger(SoftSimplesUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void openWindow(OverlayPanel overlayPanel) {
        overlayPanel.setCloseWindowListener(this);
        this.layer.setGlassPane(overlayPanel);
    }

    public void backToHome() {
        this.closeWindow();
    }

    public void closeWindow() {
        this.layer.setGlassPane(defaultGlassPane);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
