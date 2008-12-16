package com.softsimples.face.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarFile;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DiretorioRemotoWrapperImpl implements DiretorioWrapper {
    
    private URL url;
    
    public DiretorioRemotoWrapperImpl(String url) throws MalformedURLException {
        this(new URL(url));
    }

    public DiretorioRemotoWrapperImpl(URL url) {
        this.url = url;
    }
    
    @Override
    public List<PluginWrapper> listFiles() throws IOException {
        List<PluginWrapper> lista = new ArrayList<PluginWrapper>();
        URL xmlURL = new URL(this.url.toString()+"/plugins.xml");
        try {
            URLConnection connection = xmlURL.openConnection();
            connection.setUseCaches(false);
            InputStream inputStream = connection.getInputStream();            
            byte[] buffer = new byte[1024];
            int lidos = 0;
            StringBuilder builder = new StringBuilder();
            while((lidos = inputStream.read(buffer)) > -1) {
                builder.append(new String(buffer,0,lidos));
            }
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(new InputSource(new StringReader(builder.toString())));
            Element root = document.getDocumentElement();
            NodeList list = root.getElementsByTagName("plugins");
            Element plugins = (Element)list.item(0);
            NodeList pluginsList = plugins.getChildNodes();
            int size = pluginsList.getLength();
            for (int i = 0; i < size; i++) {
                Node node = pluginsList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element plugin = (Element)node;
                    String strJarFile = plugin.getAttribute("jarFile");
                    URL jarURL = new URL("jar:"+this.url.toString()+"/"+strJarFile+"!/");
                    JarURLConnection jarURLConnection = (JarURLConnection)jarURL.openConnection();
                    JarFile jarFile = jarURLConnection.getJarFile();
                    PluginWrapper pluginWrapper = new PluginWrapperImpl(jarFile, new URL(this.url+"/"+strJarFile));
                    lista.add(pluginWrapper);
                }
            }
        } catch (ParserConfigurationException configurationException) {
            configurationException.printStackTrace();
        } catch (SAXException saxException) {
            saxException.printStackTrace();
        }
        return lista;
    }    
}