/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author leoneeng
 */
public class Vagas {
    private int idVagas;
    private String nomeVagas;
    private String situacao;
    private Date tempo;

    public int getIdVagas() {
        return idVagas;
    }

    public void setIdVagas(int idVagas) {
        this.idVagas = idVagas;
    }

    public String getNomeVagas() {
        return nomeVagas;
    }

    public void setNomeVagas(String nomeVagas) {
        this.nomeVagas = nomeVagas;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getTempo() {
        return tempo;
    }

    public void setTempo(Date tempo) {
        this.tempo = tempo;
    }
    
    
}
