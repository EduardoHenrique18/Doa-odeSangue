/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doacaosangue.doacao;

import doacaosangue.doador.Doador;
import doacaosangue.medico.Medico;
import doacaosangue.receptor.Receptor;

/**
 *
 * @author semnome
 */
public class Doacao {

    private int cd_doacao;
    private String dt_doacao;
    private Doador doador;
    private Medico medico;
    private Receptor receptor;

    public Doacao() {
        this.doador = new Doador();
        this.medico = new Medico();
        this.receptor = new Receptor();
    }

    /**
     * @return the cd_doacao
     */
    public int getCd_doacao() {
        return cd_doacao;
    }

    /**
     * @param cd_doacao the cd_doacao to set
     */
    public void setCd_doacao(int cd_doacao) {
        this.cd_doacao = cd_doacao;
    }

    /**
     * @return the dt_doacao
     */
    public String getDt_doacao() {
        return dt_doacao;
    }

    /**
     * @param dt_doacao the dt_doacao to set
     */
    public void setDt_doacao(String dt_doacao) {
        this.dt_doacao = dt_doacao;
    }

    public Doador getDoador() {
        return doador;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Receptor getReceptor() {
        return receptor;
    }

    public void setReceptor(Receptor receptor) {
        this.receptor = receptor;
    }

}
