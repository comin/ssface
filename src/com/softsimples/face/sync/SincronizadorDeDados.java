package com.softsimples.face.sync;

import com.softsimples.face.sync.envio.ProcessaEnvio;
import com.softsimples.face.sync.resposta.ProcessaResposta;

public interface SincronizadorDeDados {
    public void sincronizar(ProcessaEnvio processaEnvio, ProcessaResposta processaResposta) throws Exception;
}
