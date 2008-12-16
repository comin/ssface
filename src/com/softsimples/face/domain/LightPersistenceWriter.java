package com.softsimples.face.domain;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class LightPersistenceWriter implements Runnable {
    private List<? extends Domain> lista;
    private String fileName;
    public LightPersistenceWriter(List<? extends Domain> lista, String fileName) {
        this.lista = lista;
        this.fileName = fileName;
    }

    public void run() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(this.fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(lista);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
