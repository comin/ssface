package com.softsimples.face.file;

import java.net.URL;

public class DiretorioWrapperFactory {
    public static DiretorioWrapper getDiretorioWrapper(URL url) throws Exception {
        DiretorioWrapper diretorioWrapper = null;
        if (url.getProtocol().equals("http") || url.getProtocol().equals("https")) diretorioWrapper = new DiretorioRemotoWrapperImpl(url);
        else diretorioWrapper = new DiretorioWrapperImpl(url);
        return diretorioWrapper;
    }
}
