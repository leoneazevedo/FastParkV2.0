/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import view.VagaIndividualController;

/**
 *
 * @author eng
 */
public class VagaUnica {
    
    private Pane vagaUnica;
    private VagaIndividualController controller;
    
    public VagaUnica(String Titulo) throws IOException {
                
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/VagaIndividual.fxml"));
            
            vagaUnica = loader.load();            
            controller = loader.getController();
            controller.getLbTituloVaga().setText(Titulo);            
                        
            //OBS: Só adiconar aqui Vaga e final do IP 
   
    }

    /**
     * @return the vagaUnica
     */
    public Pane getVagaUnica() {
        return vagaUnica;
    }

    /**
     * @param vagaUnica the vagaUnica to set
     */
    public void setVagaUnica(Pane vagaUnica) {
        this.vagaUnica = vagaUnica;
    }

    /**
     * @return the controller
     */
    public VagaIndividualController getController() {
        return controller;
    }
}
