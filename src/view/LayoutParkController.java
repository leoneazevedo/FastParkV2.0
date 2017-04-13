/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.layout.FlowPane;

/**
 * FXML Controller class
 *
 * @author leoneeng
 */
public class LayoutParkController implements Initializable {
    @FXML
    private Tab tabVagas;
    @FXML
    private FlowPane flowPaneVagas;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public Tab getTabVagas() {
        return tabVagas;
    }

    public void setTabVagas(Tab tabVagas) {
        this.tabVagas = tabVagas;
    }

    public FlowPane getFlowPaneVagas() {
        return flowPaneVagas;
    }

    public void setFlowPaneVagas(FlowPane flowPaneVagas) {
        this.flowPaneVagas = flowPaneVagas;
    }
    
}
