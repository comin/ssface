package com.softsimples.face.file;

import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class ManifestWrapperImpl implements ManifestWrapper {
    private Manifest manifest;
    private Attributes attributes;
    public ManifestWrapperImpl(Manifest manifest) {
        this.manifest = manifest;
        this.attributes = this.manifest.getMainAttributes();
    }

    @Override
    public String bundleClasspath() {
        return this.attributes.getValue("Bundle-Classpath");
    }
        
    @Override
    public String bundleExportPackage() {
        return this.attributes.getValue("Export-Package");
    }
    
    @Override
    public String bundleImportPackage() {
        return this.attributes.getValue("Import-Package");
    }
    
    @Override
    public String bundleActivator() {
        return this.attributes.getValue("Bundle-Activator");    
    }
    
    @Override
    public String bundleName() {
        return this.attributes.getValue("Bundle-Name");
    }
    
    @Override
    public String bundleSymbolicName() {
        return this.attributes.getValue("Bundle-SymbolicName");
    }
    
    @Override
    public String bundleVersion() {
        return this.attributes.getValue("Bundle-Version");
    }
    
    @Override
    public String bundleVendor() {
        return this.attributes.getValue("Bundle-Vendor");
    }
    
    @Override
    public String bundleCategory() {
        return this.attributes.getValue("Bundle-Category");
    }

    @Override
    public String bundleDescription() {
        return this.attributes.getValue("Bundle-Description");
    }
    
    @Override
    public boolean isValidBundle() {
        return this.isValidValue(this.bundleName()) && 
               this.isValidValue(this.bundleSymbolicName()) && 
               this.isValidValue(this.bundleVersion());
    }
    
    public boolean isValidValue(String string) {
        return (string != null && string.trim().length() > 0);
    }
}
