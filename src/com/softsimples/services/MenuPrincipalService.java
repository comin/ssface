package com.softsimples.services;

import com.softsimples.ui.base.OverlayPanel;
import com.sun.scenario.scenegraph.fx.FXImage;

public interface MenuPrincipalService {
    public FXImage addMenuItem(OverlayPanel overlayPanel);
    public void removeMenuItem(FXImage fxImage);
}
