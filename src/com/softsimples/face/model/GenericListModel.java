package com.softsimples.face.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

public class GenericListModel<DOMAIN> extends DefaultListModel {
    private static final long serialVersionUID = 1L;
    List<DOMAIN> dados;
    
    public GenericListModel() {
        dados = new ArrayList<DOMAIN>();
    }
    
    public List<DOMAIN> getList() {
        return this.dados;
    }
    
    public void setList(List<DOMAIN> dados) {
        this.dados.addAll(dados);
    }

    @Override
    public void add(int index, Object element) {
        this.dados.add(index, (DOMAIN)element);
    }

    @Override
    public void addElement(Object object) {
        this.dados.add((DOMAIN)object);
    }

    @Override
    public int capacity() {
        return this.dados.size();
    }

    @Override
    public void clear() {
        this.dados.clear();
    }

    @Override
    public boolean contains(Object object) {
        return this.dados.contains((DOMAIN)object);
    }

    @Override
    public Object elementAt(int index) {
        return this.dados.get(index);
    }

    @Override
    public Object get(int index) {
        return this.dados.get(index);
    }

    @Override
    public Object getElementAt(int index) {
        return this.dados.get(index);
    }

    @Override
    public int getSize() {
        return this.dados.size();
    }

    @Override
    public int indexOf(Object object) {
        return this.dados.indexOf((DOMAIN)object);
    }

    @Override
    public int indexOf(Object object, int index) {
        return this.dados.indexOf((DOMAIN)object);
    }

    @Override
    public void insertElementAt(Object object, int index) {
        this.dados.add(index, (DOMAIN)object);
    }

    @Override
    public boolean isEmpty() {
        return this.dados.isEmpty();
    }

    @Override
    public Object lastElement() {
        DOMAIN domain = null;
        if (this.dados.size() > 0) domain = this.dados.get(this.dados.size() -1);
        return domain;
    }

    @Override
    public int lastIndexOf(Object elem) {
        return this.dados.lastIndexOf(elem);
    }

    @Override
    public int lastIndexOf(Object elem, int index) {
        return this.dados.lastIndexOf(elem);
    }

    @Override
    public Object remove(int index) {
        return this.dados.remove(index);
    }

    @Override
    public void removeAllElements() {
        this.dados.clear();
    }

    @Override
    public boolean removeElement(Object obj) {
        return this.dados.remove(obj);
    }

    @Override
    public void removeElementAt(int index) {
        this.dados.remove(index);
    }

    @Override
    public Object set(int index, Object element) {
        return this.dados.set(index, (DOMAIN)element);
    }

    @Override
    public void setElementAt(Object obj, int index) {
        this.dados.add(index, (DOMAIN)obj);
    }

    @Override
    public int size() {
        return this.dados.size();
    }
}
