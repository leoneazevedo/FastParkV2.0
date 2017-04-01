/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author leoneeng
 */
public class VagaIndividualController implements Initializable {
    @FXML
    private Pane vagaPainel;
    @FXML
    private Label lbTituloVaga;
    @FXML
    private MenuButton cbVaga;

    public Pane getVagaPainel() {
        return vagaPainel;
    }

    public void setVagaPainel(Pane vagaPainel) {
        this.vagaPainel = vagaPainel;
    }

    public Label getLbTituloVaga() {
        return lbTituloVaga;
    }

    public void setLbTituloVaga(Label lbTituloVaga) {
        this.lbTituloVaga = lbTituloVaga;
    }

    public MenuButton getCbVaga() {
        return cbVaga;
    }

    public void setCbVaga(MenuButton cbVaga) {
        this.cbVaga = cbVaga;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void placaAction(ActionEvent event) {
    }
    
}
