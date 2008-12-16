package com.softsimples.face.domain;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LightPersistence {

    private Map<Class<? extends Domain>,List<? extends Domain>> sistemas = new HashMap<Class<? extends Domain>,List<? extends Domain>>();
    private String path;

    public LightPersistence(String path) {
        this.path = path;
    }
    
    public void limparSistemas() {
        this.criarNovosSistemas();
    }
    
    public void criarNovosSistemas() {
        sistemas = new HashMap<Class<? extends Domain>,List<? extends Domain>>();
        sistemas.put(SiteUpdate.class, new ArrayList<SiteUpdate>());
    }
    
    public <T> T getSistema(Class<? extends Domain> clazz) {
        List<? extends Domain> retorno = null;
        if (this.sistemas.containsKey(clazz)) retorno = this.sistemas.get(clazz);
        else retorno = new ArrayList();
        return (T)retorno;
    }

    public void carregar() {
        Thread bancoThread = new Thread(new LightPersistenceLoader(SiteUpdate.class, sistemas, path +File.separator+"siteUpdate.dat"));
        bancoThread.setPriority(Thread.NORM_PRIORITY);
        bancoThread.start();
    }
    
    public void gravar() {
        Thread bancoThread = new Thread(new LightPersistenceWriter(sistemas.get(SiteUpdate.class), path +File.separator+"siteUpdate.dat"));
        bancoThread.setPriority(Thread.NORM_PRIORITY);
        bancoThread.start();
    }
}
