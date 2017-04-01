/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import model.Identificador;

/**
 * FXML Controller class
 *
 * @author leoneeng
 */
public class RootParkLayoutController implements Initializable {

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("Iniciando Servidor");
        Thread m = new Thread(() -> {
            String nomeDispositivo ;
            try {
                
                ServerSocket server = new ServerSocket(3000);

                while (true) {

                    Socket conexao = server.accept();
                    System.out.println("Servidor Rodando");

                    nomeDispositivo = conexao.getInetAddress().getHostAddress();

                    new Identificador(nomeDispositivo, conexao).start();
                }
                
            } catch (IOException ex) {
                System.out.println(ex);                
            }
        });
        
        m.start();
    }
}
