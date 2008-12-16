package com.softsimples.face.file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DiretorioWrapperImpl implements DiretorioWrapper {
    private File diretorio;
    private static FileFilter fileFilter = new FileFilter() {
        @Override
        public boolean accept(File pathName) {
            return (pathName.getAbsolutePath().lastIndexOf(".jar") > -1);
        }
    };
    public DiretorioWrapperImpl(URL url) throws Exception {
        this.diretorio = new File(url.getFile());
        if (!this.diretorio.isDirectory()) throw new Exception("Url não é um diretório válido!");
    }
    
    @Override
    public List<PluginWrapper> listFiles() throws IOException {
        File[] files = this.diretorio.listFiles(fileFilter);
        List<PluginWrapper> arquivos = new ArrayList<PluginWrapper>();
        for (File file : files) {
            PluginWrapper pluginWrapper = new PluginWrapperImpl(file);
            if (pluginWrapper.isValidPlugin()) arquivos.add(pluginWrapper);
        }
        return arquivos;
    }
}
