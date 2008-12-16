package com.softsimples.face.util;

import javax.swing.JOptionPane;

public class UtilidadesGraficas {
    public static void abrirTelaDeAlerta(String msg) {
        JOptionPane.showMessageDialog(null, msg, "SoftSimples", JOptionPane.WARNING_MESSAGE);
    }
    
    public static boolean abrirTelaDeConfirmacao(String msg) {
        int confirma = JOptionPane.showConfirmDialog(null, msg, "SoftSimples", JOptionPane.OK_CANCEL_OPTION);
        return confirma == JOptionPane.OK_OPTION;               
    }

    public static void abrirTelaDeInformacao(String msg) {
        JOptionPane.showMessageDialog(null, msg, "SoftSimples", JOptionPane.INFORMATION_MESSAGE);
    }
}
