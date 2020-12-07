/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dilan.controller;

import com.dilan.colorearimagenes.App;
import com.dilan.util.GestorArchivosImg;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author dilan
 */
public class PrincipalController implements Initializable {


    @FXML
    private ImageView imgViewSubida;
    @FXML
    private Button botonSubirImg;
    @FXML
    private ImageView imgViewResultado;
    private static Scene scene;
    private static  final Stage stage =new Stage();;
    @FXML
    private Button botonSubirImg1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    private void subirImagen(MouseEvent event) throws InterruptedException {
        imgViewSubida.setImage(null);
        imgViewResultado.setImage(null);
        try {
            File archivo = GestorArchivosImg.obtenerImg();
            imgViewSubida.setImage(new Image(new  FileInputStream(archivo)));
            String comando = "python3 color.py "+archivo.getPath();
            scene = new Scene(App.loadFXML("Progreso"));
            stage.setScene(scene);
            stage.show();
            new Thread(() -> {
                 try {
                     Scanner sc = new Scanner(Runtime.getRuntime().exec(comando).getInputStream());
                     imgViewResultado.setImage(new Image(sc.next()));
                     
                 } catch (IOException ex) {
                     Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
                     stage.close();
                 }
                 Platform.runLater(() -> {
                     stage.close();
                 });
            }).start();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    
    }

    @FXML
    private void guardarImagen(MouseEvent event) {
        GestorArchivosImg.guardarImg(imgViewResultado);
    }
    
    

}
