package com.softsimples.face;

import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Boot {
    private SoftSimplesFrame softSimplesFrame;

    public Boot() {
        this.softSimplesFrame = new SoftSimplesFrame();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                softSimplesFrame.setVisible(true);
            }
        });
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new NimbusLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SoftSimplesUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Boot();
    }
}
