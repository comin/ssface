package com.softsimples.face.file;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.jar.JarFile;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PluginWrapperImpl implements PluginWrapper {
    private JarFile arquivo;
    private URL url;
    
    public PluginWrapperImpl(String arquivo) throws IOException {
        this(new File(arquivo));
    }
    
    public PluginWrapperImpl(URI arquivo) throws IOException {
        this(new File(arquivo));
    }
    
    public PluginWrapperImpl(File arquivo) throws IOException {
        this.url = arquivo.toURI().toURL();
        this.arquivo = new JarFile(arquivo);
    }
    
    public PluginWrapperImpl(JarFile arquivo, URL url) throws IOException {        
        this.arquivo = arquivo;
        this.url = url;
    }
    
    @Override
    public ManifestWrapper getManifest() throws IOException {
        ManifestWrapper manifestWrapper = new ManifestWrapperImpl(this.arquivo.getManifest());
        return manifestWrapper;
    }
    
    @Override
    public URL getUrl() throws MalformedURLException {
        return this.url;
    }
    
    @Override
    public boolean isValidPlugin() {
        boolean retorno = false;
        try {
            retorno = this.getManifest().isValidBundle();
        } catch (IOException ex) {
            Logger.getLogger(PluginWrapperImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
}