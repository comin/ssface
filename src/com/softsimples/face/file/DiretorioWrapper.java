package com.softsimples.face.file;

import java.io.IOException;
import java.util.List;

public interface DiretorioWrapper {
    public List<PluginWrapper> listFiles() throws IOException;
}
