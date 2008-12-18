package com.softsimples.face;

import com.softsimples.face.resource.Resource;
import com.softsimples.face.resource.ResourceType;
import com.softsimples.face.services.MenuPrincipalService;
import com.softsimples.face.services.MenuPrincipalServiceImpl;
import com.softsimples.ui.base.CloseWindowListener;
import com.softsimples.ui.base.OpenWindowListener;
import com.softsimples.ui.base.OverlayPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;
import org.jdesktop.jxlayer.JXLayer;
import org.knopflerfish.framework.Framework;
import org.osgi.framework.BundleContext;

public class SoftSimplesFrame extends JFrame implements OpenWindowListener, CloseWindowListener {

    private SoftSimplesMenu softSimplesMenu;
    private JXLayer layer;
    private JComponent defaultGlassPane;

    public SoftSimplesFrame() {
        this.softSimplesMenu = new SoftSimplesMenu(this, "/background/fundo2.jpg");
        this.layer = new JXLayer(this.softSimplesMenu);
        this.defaultGlassPane = this.layer.getGlassPane();
        add(layer, BorderLayout.CENTER);
        softSimplesMenu.executar();
        this.ajustarTamanho();
    }

    @Override
    public void setVisible(boolean isVisible) {
        super.setVisible(isVisible);
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    loadOSGIFramework();
                    startOSGIFramework();
                } catch (Exception ex) {
                    Logger.getLogger(SoftSimplesFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
    }

    public void ajustarTamanho() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        Rectangle rectangle = new Rectangle(0,0,800, 600);
        int posX = (dimension.width / 2) - (rectangle.width / 2);
        int posY = (dimension.height / 2) - (rectangle.height / 2);
        rectangle.x = posX;
        rectangle.y = posY;
        this.setBounds(rectangle);
    }

    public void loadOSGIFramework() throws Exception {
        Framework framework = OSGIFramework.getFramework();
        BundleContext bundleContext = framework.getSystemBundleContext();
        bundleContext.registerService(MenuPrincipalService.class.getName(), new MenuPrincipalServiceImpl(softSimplesMenu), new Properties());
        Resource.add(ResourceType.OSGIFramework, framework);
        this.softSimplesMenu.comecarPaineisOSGI();
    }

    public void startOSGIFramework() throws Exception {
        Framework framework = OSGIFramework.getFramework();
        framework.launch(0);
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
