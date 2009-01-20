package com.softsimples.face.domain;

import com.softsimples.face.sync.SincronizadorDeDados;
import com.softsimples.face.sync.SincronizadorDeDadosHttp;
import com.softsimples.face.sync.envio.ProcessaEnvio;
import com.softsimples.face.sync.resposta.ProcessaResposta;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class SiteUpdate extends Domain {
    private static final long serialVersionUID = 1L;
    private String nome;
    private String uri;
    private List<SitePlugin> listaDePlugins;
    
    public SiteUpdate() {}

    public SiteUpdate(String uri) {
        this.uri = uri;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
    
    public static List<SitePlugin> getPluginsDisponiveis(String uri) throws Exception {
        SincronizadorDeDados sincronizadorDeDados = new SincronizadorDeDadosHttp(new URI(uri));
        MeuProcessadorDeResposta processadorDeResposta = new MeuProcessadorDeResposta();
        sincronizadorDeDados.sincronizar(new MeuProcessadorDeEnvio(), processadorDeResposta);
        return processadorDeResposta.getPlugins();
    }

    private static class MeuProcessadorDeEnvio implements ProcessaEnvio {
        public JSONObject processa() {
            JSONObject jsonObject = new JSONObject();
            return jsonObject;
        }
    }

    private static class MeuProcessadorDeResposta implements ProcessaResposta {
        private List<SitePlugin> plugins;
        
        public MeuProcessadorDeResposta() {
            this.plugins = new ArrayList<SitePlugin>();
        }

        public void processa(JSONObject jsonObject) throws Exception {
            System.out.println(jsonObject);
            JSONArray jsonPlugins = jsonObject.getJSONArray("objetos");
            int size = jsonPlugins.length();
            for (int i = 0; i < size; i++) {
                JSONObject jsonPlugin = jsonPlugins.getJSONObject(i);
                SitePlugin sitePlugin = new SitePlugin(jsonPlugin.getJSONObject("plugin"));
                this.plugins.add(sitePlugin);
            }
        }

        public List<SitePlugin> getPlugins() {
            return this.plugins;
        }
    }
}
