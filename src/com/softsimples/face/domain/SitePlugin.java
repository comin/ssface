package com.softsimples.face.domain;

import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

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
    
    public SitePlugin(JSONObject jsonPlugin) {
        try {
            this.setNomeSimbolico(jsonPlugin.getString("bundle_symbolic_name"));
            this.setCategoria(jsonPlugin.getString("bundle_category"));
            this.setActivator(jsonPlugin.getString("bundle_activator"));
            this.setNome(jsonPlugin.getString("bundle_name"));
            this.setAutor(jsonPlugin.getString("bundle_vendor"));
            this.setDescricao(jsonPlugin.getString("bundle_description"));
            this.setVersao(jsonPlugin.getString("bundle_version"));
            this.setUrl(new URL("http://www.softsimples.com.br/plugins/"+jsonPlugin.getString("bundle_server_path")));
        } catch (Exception ex) {
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
