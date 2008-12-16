package com.softsimples.face.domain;

import com.softsimples.face.file.ManifestWrapper;
import com.softsimples.face.file.PluginWrapper;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SitePlugin extends Domain {
    private static final long serialVersionUID = 1L;
    
    private String nomeSimbolico;
    private String activator;
    private String nome;
    private String versao;
    private String autor;
    private String descricao;
    private String categoria;
    private String importPackage;
    private String exportPackage;
    private String classpath;
    private URL url;
    
    public SitePlugin() {}
    
    public SitePlugin(PluginWrapper pluginWrapper) {
        ManifestWrapper manifestWrapper;
        try {
            manifestWrapper = pluginWrapper.getManifest();
            this.setNomeSimbolico(manifestWrapper.bundleSymbolicName());
            this.setImportPackage(manifestWrapper.bundleImportPackage());
            this.setExportPackage(manifestWrapper.bundleExportPackage());
            this.setClasspath(manifestWrapper.bundleClasspath());
            this.setCategoria(manifestWrapper.bundleCategory());
            this.setActivator(manifestWrapper.bundleActivator());
            this.setNome(manifestWrapper.bundleName());
            this.setAutor(manifestWrapper.bundleVendor());
            this.setDescricao(manifestWrapper.bundleDescription());
            this.setVersao(manifestWrapper.bundleVersion());
            this.setUrl(pluginWrapper.getUrl());
        } catch (IOException ex) {
            Logger.getLogger(SitePlugin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNomeSimbolico() {
        return nomeSimbolico;
    }

    public void setNomeSimbolico(String nomeSimbolico) {
        this.nomeSimbolico = nomeSimbolico;
    }

    public String getClasspath() {
        return classpath;
    }

    public void setClasspath(String classpath) {
        this.classpath = classpath;
    }

    public String getExportPackage() {
        return exportPackage;
    }

    public void setExportPackage(String exportPackage) {
        this.exportPackage = exportPackage;
    }

    public String getImportPackage() {
        return importPackage;
    }

    public void setImportPackage(String importPackage) {
        this.importPackage = importPackage;
    }
    
    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getActivator() {
        return activator;
    }

    public void setActivator(String activator) {
        this.activator = activator;
    }
    
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }    
}
