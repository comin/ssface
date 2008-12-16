package com.softsimples.services;

import com.softsimples.face.SoftSimplesMenu;
import com.softsimples.ui.base.OverlayPanel;
import com.sun.scenario.scenegraph.fx.FXImage;

public class MenuPrincipalServiceImpl implements MenuPrincipalService {
    private SoftSimplesMenu softSimplesMenu;
    public MenuPrincipalServiceImpl(SoftSimplesMenu softSimplesMenu) {
        this.softSimplesMenu = softSimplesMenu;
    }

    public FXImage addMenuItem(OverlayPanel overlayPanel) {
        return this.softSimplesMenu.addMenuItem(overlayPanel);
    }

    public void removeMenuItem(FXImage fxImage) {
        this.softSimplesMenu.removeMenuItem(fxImage);
    }
}
