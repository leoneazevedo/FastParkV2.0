/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.VagaUnica;
import view.LayoutParkController;

/**
 *
 * @author leoneeng
 */
public class Servidor extends Application {

    public static BorderPane rootParkLayout;
    public static AnchorPane layoutPark;
    public static Stage palco;
    public static Scene cena;

    private static ObservableList<VagaUnica> listaDeVagas = FXCollections.observableArrayList();

    private static LayoutParkController layoutParkController;
   
    public static ObservableList<VagaUnica> getListaDeVagas() {
        return listaDeVagas;
    }

    public static LayoutParkController getLayoutController() {
        return layoutParkController;
    }

  
    @Override
    public void start(Stage palco) {

        listaDeVagas.addListener(new ListChangeListener() {

            @Override
            public void onChanged(ListChangeListener.Change change) {

               layoutParkController.getFlowPaneVagas().getChildren().clear();

                listaDeVagas.forEach(item -> layoutParkController.getFlowPaneVagas().getChildren().add(item.getVagaUnica()));

            }
        });

        try {

            palco.setTitle("FastPark");

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/RootParkLayout.fxml"));

            rootParkLayout = loader.load();

            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(getClass().getResource("/view/LayoutPark.fxml"));
            layoutPark = loader2.load();

            layoutParkController = loader2.getController();

            cena = new Scene(rootParkLayout);
            palco.setScene(cena);
            rootParkLayout.setCenter(layoutPark);
            palco.show();

           Platform.runLater(() -> {
                for (int i = 100; i <= 120; i++) {
                    try {
                        listaDeVagas.add(new VagaUnica(String.valueOf("192.168.1." + i)));
                 //       listaDeVagas.sort((VagaUnica o1, VagaUnica o2) -> o1.getController().getLbTituloVaga().toString().compareTo(o2.getController().getLbTituloVaga().toString()));
                  //      listaDeVagas.sort((VagaUnica o1, VagaUnica o2) -> o1.getController().getLbTituloVaga().toString().compareTo(o2.getController().getLbTituloVaga().toString()));
                    } catch (IOException ex) {
                        Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

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
            } else {
                arg0.consume();
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
