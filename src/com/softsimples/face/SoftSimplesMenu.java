package com.softsimples.face;

import com.softsimples.face.config.BundleConfigFormPanel;
import com.softsimples.ui.base.MenuPanel;
import com.softsimples.ui.base.OpenWindowListener;
import com.softsimples.ui.base.OverlayPanel;
import com.softsimples.ui.base.menu.MenuTooltip;
import com.sun.scenario.effect.Reflection;
import com.sun.scenario.scenegraph.SGNode;
import com.sun.scenario.scenegraph.SGTransform;
import com.sun.scenario.scenegraph.fx.FXGroup;
import com.sun.scenario.scenegraph.fx.FXImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class SoftSimplesMenu extends MenuPanel {
    private static final long serialVersionUID = 1L;
    private MenuTooltip blogTooltip;
    private SGTransform.Translate blogTranslation;
    
    private BundleConfigFormPanel bundleConfigOverlay;
    private FXGroup bundleGroup;
    
    public SoftSimplesMenu() {
        this(null, "/background/fundo2.jpg");
    }
    
    public SoftSimplesMenu(OpenWindowListener openWindowListener, String background) {
        super(openWindowListener, background);
    }

    @Override
    public void executar() {
        this.blogTooltip = new MenuTooltip();
        this.blogTranslation = SGTransform.createTranslation(0, 0, this.blogTooltip);
        
        reflection = new Reflection();
        reflection.setFraction(0.9f);
        mainGroup = new FXGroup();
        bundleGroup = new FXGroup();
        menuGroup = new FXGroup();
        this.configurePanels();
        mainGroup.add(bundleGroup);
        mainGroup.add(menuGroup);
        mainGroup.add(blogTranslation);
        this.loadBundleImage();
        this.setScene(mainGroup);
    }

    @Override
    public void configurePanels() {
        this.bundleConfigOverlay = new BundleConfigFormPanel();
    }

    public void comecarPaineisOSGI() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                bundleConfigOverlay.startOSGI();
            }
        });
        thread.setPriority(Thread.NORM_PRIORITY);
        thread.start();
        
    }

    public void removeMenuItem(FXImage fxImage) {
        this.menuGroup.remove(fxImage);
    }
    
    public FXImage addMenuItem(final OverlayPanel overlayPanel) {
        FXImage menuItemIcon = null;
        try {
            menuItemIcon = loadImage(overlayPanel.getMenuIcon());
            menuItemIcon.addMouseListener(new MenuMouseAdapter() {
                @Override
                    public void mouseEntered(MouseEvent event, SGNode node) {
                        blogTooltip.setTitle(overlayPanel.getTituloTela());
                        this.fadeIn(node, blogTranslation, blogTooltip);
                        super.mouseEntered(event, node);
                    }

                @Override
                    public void mouseExited(MouseEvent event, SGNode node) {
                        this.fadeOut(blogTooltip);
                        super.mouseExited(event, node);
                    }

                @Override
                    public void mouseClicked(MouseEvent event, SGNode node) {
                        openWindowListener.openWindow(overlayPanel);
                    }
                }
            );
            menuItemIcon.setTranslateX(iconSize);
            menuGroup.add(menuItemIcon);
            calcularNovaPosicao(menuItemIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return menuItemIcon;
    }
    
    public void loadBundleImage() {
        try {
            FXImage bundleConfigIcon = loadImage(MenuPanel.class.getResourceAsStream("/menu/package.png"));
                bundleConfigIcon.addMouseListener(new MenuMouseAdapter() {
                @Override
                    public void mouseEntered(MouseEvent event, SGNode node) {
                        blogTooltip.setTitle("Configuração de plugins");
                        fadeInBundle(node, blogTranslation, blogTooltip);
                        super.mouseEntered(event, node);
                    }

                @Override
                    public void mouseExited(MouseEvent event, SGNode node) {
                        this.fadeOut(blogTooltip);
                        super.mouseExited(event, node);
                    }

                @Override
                    public void mouseClicked(MouseEvent event, SGNode node) {
                        openWindowListener.openWindow(bundleConfigOverlay);
                    }
                }
            );
            bundleGroup.add(bundleConfigIcon);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    protected void paintComponent(Graphics graphics) {
        Rectangle rectangle = this.getBounds();
        if (bundleGroup != null) {
            bundleGroup.setTranslateX(20);
            bundleGroup.setTranslateY(rectangle.height - 100);
        }
        super.paintComponent(graphics);
    }
    
    @Override
    public BufferedImage paintGradient(Graphics graphics) {
        if (gradient == null || gradient.getWidth() != this.getWidth() || gradient.getHeight() != this.getHeight()) {
            gradient = this.graphicsConfiguration.createCompatibleImage(this.getWidth(), this.getHeight());
            Graphics2D graphics2D = (Graphics2D) gradient.getGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            graphics2D.setBackground(Color.WHITE);
            graphics2D.fillRect(0, 0, gradient.getWidth(), gradient.getHeight());
            graphics2D.setPaint(new TexturePaint(backgroundImage, new Rectangle(0,0,gradient.getWidth(), gradient.getHeight())));
            graphics2D.fillRect(0, 0, gradient.getWidth(), gradient.getHeight());
            graphics2D.dispose();
        }
        return gradient;
    }
    
    public void fadeInBundle(SGNode node, SGTransform.Translate translate, MenuTooltip menuTooltip) {
            double meioDaTelaY = ((double)node.getPanel().getBounds().height - 215);
            translate.setTranslateX(20);
            translate.setTranslateY(meioDaTelaY);
            menuTooltip.fadeIn();
        }

    @Override
    public void loadImages() {}
}
