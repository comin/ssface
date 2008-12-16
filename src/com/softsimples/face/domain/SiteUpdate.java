package com.softsimples.face.domain;

import com.softsimples.face.file.DiretorioWrapper;
import com.softsimples.face.file.DiretorioWrapperFactory;
import com.softsimples.face.file.PluginWrapper;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SiteUpdate extends Domain {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String url;
    private List<SitePlugin> listaDePlugins;
    
    public SiteUpdate(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public static List<PluginWrapper> getPluginsDisponiveis(URL url) throws Exception {
        DiretorioWrapper diretorioWrapper = DiretorioWrapperFactory.getDiretorioWrapper(url);
        return diretorioWrapper.listFiles();
    }
    
    public List<SitePlugin> getListaDePlugins() throws Exception {
        if (listaDePlugins == null) listaDePlugins = new ArrayList<SitePlugin>();
        if (listaDePlugins.size() == 0) {
            DiretorioWrapper diretorioWrapper = DiretorioWrapperFactory.getDiretorioWrapper(new URL(this.getUrl()));
            List<PluginWrapper> listaWrappers = diretorioWrapper.listFiles();
            for (PluginWrapper pluginWrapper : listaWrappers) {
                listaDePlugins.add(new SitePlugin(pluginWrapper));
            }
        }
        return listaDePlugins;
    }
}
