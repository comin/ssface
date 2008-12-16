package com.softsimples.face.config;

import com.softsimples.ui.base.BasicFormPanel;
import java.net.URL;
import javax.swing.JToolBar;

public class BundleConfigFormPanel extends BasicFormPanel {
    private static final long serialVersionUID = 1L;
    
    private BundleConfigPanel bundleConfigPanel;
    
    public BundleConfigFormPanel() {
        super(650, 360, "Configuração de plugins");
    }
    
    @Override
    public void cancelar() {}

    @Override
    public void excluir() {}

    @Override
    public void imprimir() {}

    @Override
    public void limpar() {}

    @Override
    public void novo() {}

    @Override
    public void pesquisar() {}

    @Override
    public void salvar() {}

    @Override
    protected void configurePanel() {
        this.bundleConfigPanel = new BundleConfigPanel();
        this.addPanel(bundleConfigPanel);
    }

    @Override
    public JToolBar getToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setOpaque(false);
        toolBar.setBorder(null);
        toolBar.setFloatable(false);
        toolBar.setBorderPainted(false);
        return toolBar;
    }

    @Override
    public URL getMenuIcon() {
        return null;
    }
}
