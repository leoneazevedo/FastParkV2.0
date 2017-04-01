/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eng
 */
public class Identificador extends Thread {
    
    private final Socket conexao;
    private final String nomeDispositivo;//IP de cada dispositivo conectado
        

    public Identificador(String nomeDispositivo, Socket conexao) {
        this.nomeDispositivo = nomeDispositivo;
        this.conexao = conexao;
    }

    @Override
    public void run() {            
     
        try {
            System.out.println(nomeDispositivo + " Conectado...");
            PrintStream saida = new PrintStream(this.conexao.getOutputStream(), true);       
            Scanner entrada = new Scanner(this.conexao.getInputStream());                                                                                         
                                    
            while (entrada.hasNextLine()) {
                
                   System.out.println(entrada.nextLine());
                   
             }                                                           
            } catch (IOException ex) {
                
            Logger.getLogger(Identificador.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}