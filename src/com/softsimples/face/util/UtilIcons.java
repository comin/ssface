package com.softsimples.face.util;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class UtilIcons {
    
    private static ImageIcon FIND_BUNDLE;
    private static ImageIcon INSTALED_BUNDLE;
    private static ImageIcon ADD_BUNDLE;
    private static ImageIcon DETAILS_BUNDLE;
    
    public static ImageIcon findBundleIcon() {
        if (FIND_BUNDLE == null) {
            try {
                BufferedImage image = ImageIO.read(UtilIcons.class.getResourceAsStream("/icons/package_find.png"));
                FIND_BUNDLE = new ImageIcon(image);
            } catch (IOException ex) {
                Logger.getLogger(UtilIcons.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return FIND_BUNDLE;
    }
    
    public static ImageIcon instaledBundleIcon() {
        if (INSTALED_BUNDLE == null) {
            try {
                BufferedImage image = ImageIO.read(UtilIcons.class.getResourceAsStream("/icons/package_ok.png"));
                INSTALED_BUNDLE = new ImageIcon(image);
            } catch (IOException ex) {
                Logger.getLogger(UtilIcons.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return INSTALED_BUNDLE;
    }
    
    public static ImageIcon addBundleIcon() {
        if (ADD_BUNDLE == null) {
            try {
                BufferedImage image = ImageIO.read(UtilIcons.class.getResourceAsStream("/icons/package_add.png"));
                ADD_BUNDLE = new ImageIcon(image);
            } catch (IOException ex) {
                Logger.getLogger(UtilIcons.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ADD_BUNDLE;
    }
    
    public static ImageIcon detailsBundleIcon() {
        if (DETAILS_BUNDLE == null) {
            try {
                BufferedImage image = ImageIO.read(UtilIcons.class.getResourceAsStream("/icons/package_preferences.png"));
                DETAILS_BUNDLE = new ImageIcon(image);
            } catch (IOException ex) {
                Logger.getLogger(UtilIcons.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return DETAILS_BUNDLE;
    }
}
