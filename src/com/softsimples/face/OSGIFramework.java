package com.softsimples.face;

import java.io.File;
import org.knopflerfish.framework.Framework;
import org.osgi.framework.Constants;

public class OSGIFramework {
    private static Framework FRAMEWORK;
    private static String USER_DIR;
    
    public OSGIFramework() {}
    
    public static Framework getFramework() throws Exception {
        if (FRAMEWORK == null) {
            configurarDiretorioDaAplicacao();
            configurarOSGI();
        }
        return FRAMEWORK;
    }
    
    private static void configurarDiretorioDaAplicacao() {
         USER_DIR = System.getProperty("user.home")+"/.softsimples/";
        File userDirFile = new File(USER_DIR);
        if (!userDirFile.exists()) userDirFile.mkdir();
    }
    
    private static void configurarOSGI() throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("javax.accessibility,");
        stringBuilder.append("javax.net,");
        stringBuilder.append("javax.net.ssl,");
        stringBuilder.append("javax.swing,");
        stringBuilder.append("javax.swing.tree,");
        stringBuilder.append("javax.swing.border,");
        stringBuilder.append("javax.swing.event,");
        stringBuilder.append("javax.swing.filechooser,");
        stringBuilder.append("javax.swing.plaf,");
        stringBuilder.append("javax.swing.plaf.basic,");
        stringBuilder.append("javax.swing.plaf.metal,");
        stringBuilder.append("javax.swing.table,");
        stringBuilder.append("javax.swing.text,");
        stringBuilder.append("javax.swing.tree,");
        stringBuilder.append("javax.swing.plaf,");
        stringBuilder.append("javax.swing.filechooser,");
        stringBuilder.append("javax.imageio,");
        stringBuilder.append("javax.management,");
        stringBuilder.append("javax.crypto.spec,");
        stringBuilder.append("javax.crypto,");
        stringBuilder.append("javax.xml.parsers,");
        stringBuilder.append("org.w3c.dom,");
        stringBuilder.append("sun.reflect,org.w3c.dom,");
        stringBuilder.append("org.xml.sax,");
        stringBuilder.append("org.jdesktop.swingx.painter,");
        stringBuilder.append("org.jdesktop.jxlayer.plaf.ext,");
        stringBuilder.append("com.sun.scenario.scenegraph,");
        stringBuilder.append("org.jdesktop.jxlayer.plaf,");
        stringBuilder.append("org.jdesktop.jxlayer,");
        stringBuilder.append("org.jdesktop.jxlayer.plaf.effect,");
        stringBuilder.append("com.sun.scenario.effect,");
        stringBuilder.append("com.sun.scenario.scenegraph.fx,");
        stringBuilder.append("com.sun.scenario.scenegraph.event,");
        stringBuilder.append("com.sun.scenario.animation,");
        stringBuilder.append("javax.print.attribute,");
        stringBuilder.append("javax.print,");
        stringBuilder.append("com.softsimples.services");
        Framework.setProperty(Constants.FRAMEWORK_SYSTEMPACKAGES, stringBuilder.toString());
        Framework.setProperty(Constants.EXPORT_PACKAGE, "com.softsimples.face,com.softsimples.services");
        Framework.setProperty("org.osgi.framework.dir", USER_DIR+"fwdir");
        Framework.setProperty("org.knopflerfish.gosg.jars", "jars");
        Framework.setProperty("org.knopflerfish.verbosity", "0");
        FRAMEWORK = new Framework(new Object());
    }
}
