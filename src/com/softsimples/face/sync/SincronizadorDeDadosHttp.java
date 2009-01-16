package com.softsimples.face.sync;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SincronizadorDeDadosHttp extends SincronizadorDeDadosAbstract {
    private HttpURLConnection connection;
    
    public SincronizadorDeDadosHttp(URI uri) {
        super(uri);
    }
    
    @Override
    public void abrirConexao() {
        try {
            URL url = this.uri.toURL();
            this.connection = (HttpURLConnection)url.openConnection();
            this.connection.setRequestMethod("POST");
            this.connection.setDoOutput(true);
            this.connection.setDoInput(true);
            this.connection.setInstanceFollowRedirects(true);
        } catch (Exception ex) {
            Logger.getLogger(SincronizadorDeDadosHttp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public InputStream abrirStream() throws IOException {
        return this.connection.getInputStream();
    }

    @Override
    public OutputStream abrirOutputStream() throws IOException {
        return this.connection.getOutputStream();
    }
}
