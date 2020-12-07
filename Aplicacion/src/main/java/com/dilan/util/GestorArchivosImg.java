/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dilan.util;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 *
 * @author dilan
 */
public class GestorArchivosImg {
    private  static FileChooser  gestor = null;

    public static File obtenerImg() {
        if (gestor == null) {
            gestor = new FileChooser();
            gestor.setTitle("Buscar Imagen");
            // Agregar filtros para facilitar la busqueda
            gestor.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("JPG", "*.jpg"),
                    new FileChooser.ExtensionFilter("PNG", "*.png")
            );
            return gestor.showOpenDialog(null);
        } else {

            return gestor.showOpenDialog(null);
        }

    }
    
    public static void guardarImg(ImageView imagen){
        File ruta = gestor.showSaveDialog(null);
        if(ruta!=null){
            try {
                String name = ruta.getName();
                BufferedImage img = SwingFXUtils.fromFXImage(imagen.getImage(), null);
                ImageIO.write(img, "png", ruta);
            } catch (IOException ex) {
                Logger.getLogger(GestorArchivosImg.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    
    }
    
    
    
}
