package com.softsimples.face.config.render;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import org.osgi.framework.Bundle;

public class PluginInstaladoRenderer extends DefaultListCellRenderer {
    private static final long serialVersionUID = 1L;
    
    public PluginInstaladoRenderer() {}

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Color color = cellHasFocus ? list.getSelectionBackground() : Color.WHITE;
        PluginInstaladoRendererPanel bancoRendererPanel = new PluginInstaladoRendererPanel((Bundle)value, isSelected, color);
        return bancoRendererPanel;
    }
}
