package com.softsimples.face.sync;

import com.softsimples.face.sync.envio.ProcessaEnvio;
import com.softsimples.face.sync.resposta.ProcessaResposta;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;


public abstract class SincronizadorDeDadosAbstract implements SincronizadorDeDados {
    protected URI uri;
    
    public SincronizadorDeDadosAbstract(URI uri) {
        this.uri = uri;
    }
    
    public abstract void abrirConexao();
    public abstract InputStream abrirStream() throws IOException;
    public abstract OutputStream abrirOutputStream() throws IOException;
    
    @Override
    public void sincronizar(ProcessaEnvio processaEnvio, ProcessaResposta processaResposta) throws Exception {
        this.abrirConexao();
        this.enviar(processaEnvio);
        this.receberResposta(processaResposta);
    }
    
    public double getTempoEmSegundos(long tempoEmMilesegundos) {
        return (tempoEmMilesegundos / 1000d);
    }
    
    public void enviar(ProcessaEnvio processaEnvio) throws Exception {
        long inicio = System.currentTimeMillis();
        OutputStream outputStream = this.abrirOutputStream();
        JSONObject protocoloEnvio = processaEnvio.processa();
        this.compactar(protocoloEnvio, outputStream);
        long fim = System.currentTimeMillis();
        System.out.println("envio: "+this.getTempoEmSegundos(fim - inicio));
    }
    
    public void receberResposta(ProcessaResposta processaResposta) throws Exception {
        long inicio = System.currentTimeMillis();
        JSONObject protocoloResposta = this.descompactar(this.abrirStream());
        long fim = System.currentTimeMillis();
        System.out.println("download: "+this.getTempoEmSegundos(fim - inicio));
        processaResposta.processa(protocoloResposta);
    }
    
    public JSONObject descompactar(InputStream inputStream) throws IOException, JSONException {
        JSONObject jsonObject = null;
        GZIPInputStream zipInputStream = new GZIPInputStream(inputStream);
        byte[] buffer = new byte[1024];
        int lidos = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while((lidos = zipInputStream.read(buffer)) > -1) stringBuilder.append(new String(buffer,0,lidos));
        jsonObject = new JSONObject(stringBuilder.toString());
        return jsonObject;
    }
    
    public void compactar(JSONObject jsonObject, OutputStream outputStream) throws IOException {
        GZIPOutputStream zipOutputStream = new GZIPOutputStream(outputStream);
        zipOutputStream.write(jsonObject.toString().getBytes());
        zipOutputStream.flush();
        zipOutputStream.close();
    }
}