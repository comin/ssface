package com.softsimples.face.domain;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LightPersistenceLoader implements Runnable {
    Map<Class<? extends Domain>,List<? extends Domain>> sistemas;
    private String fileName;
    private Class<? extends Domain> clazz;
    
    public LightPersistenceLoader(Class<? extends Domain> clazz, Map<Class<? extends Domain>,List<? extends Domain>> sistemas, String fileName) {
        this.sistemas = sistemas;
        this.clazz = clazz;
        this.fileName = fileName;
    }

    public void run() {
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<? extends Domain> lista = (List<? extends Domain>)objectInputStream.readObject();
            sistemas.put(clazz, lista);
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            sistemas.put(clazz, new ArrayList<Domain>());
        }
    }
}
