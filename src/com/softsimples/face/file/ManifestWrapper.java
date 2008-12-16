package com.softsimples.face.file;

public interface ManifestWrapper {

    public String bundleClasspath();
    
    public String bundleExportPackage();
    
    public String bundleImportPackage();
    
    public String bundleActivator();
    
    String bundleName();
    
    String bundleSymbolicName();
            
    String bundleCategory();

    String bundleDescription();

    String bundleVendor();

    String bundleVersion();
    
    boolean isValidBundle();

}
