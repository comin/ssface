package com.softsimples.face.sync.resposta;

import org.json.JSONObject;

public interface ProcessaResposta {
    public void processa(JSONObject jsonObject)throws Exception;
}
