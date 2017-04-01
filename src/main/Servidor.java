/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author leoneeng
 */
public class Servidor extends Application {

    public static BorderPane rootParkLayout;
    public static FlowPane layoutPark;
    public static Stage palco;
    public static Scene cena;

    @Override
    public void start(Stage palco) {

        try {
            palco.setTitle("FastPark");

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/RootParkLayout.fxml"));

            rootParkLayout = loader.load();

            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(getClass().getResource("/view/LayoutPark.fxml"));
            layoutPark = loader2.load();

            cena = new Scene(rootParkLayout);
            palco.setScene(cena);           
            palco.centerOnScreen();
            palco.show();

            rootParkLayout.setCenter(layoutPark);
            
        } catch (IOException ex) {
            
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        palco.setOnCloseRequest((WindowEvent arg0) -> {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("FastParking");
            alert.setHeaderText("Diálogo de Confirmação");
            alert.setContentText("Deseja realmente sair?");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.get() == ButtonType.OK) {
                System.exit(0);                
            }
        });
    }
                
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
