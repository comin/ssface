package com.softsimples.face.file;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public interface PluginWrapper {

    ManifestWrapper getManifest() throws IOException;
    URL getUrl() throws MalformedURLException;
    boolean isValidPlugin();

}
