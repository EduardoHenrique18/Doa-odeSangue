/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doacaosangue.doador;

import doacaosangue.doacao.Doacao;
import java.util.ArrayList;

/**
 *
 * @author semnome
 */
public class Doador {

    private String cpf_doador;
    private String nome;
    private String endereco;
    private String sexo;
    private String tp_sangue;

    private ArrayList<Doacao> doacao;

    public Doador(){
        this.doacao = new ArrayList<Doacao>();
    }


    /**
     * @return the cpf_doador
     */
    public String getCpf_doador() {
        return cpf_doador;
    }

    /**
     * @param cpf_doador the cpf_doador to set
     */
    public void setCpf_doador(String cpf_doador) {
        this.cpf_doador = cpf_doador;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the tp_sangue
     */
    public String getTp_sangue() {
        return tp_sangue;
    }

    /**
     * @param tp_sangue the tp_sangue to set
     */
    public void setTp_sangue(String tp_sangue) {
        this.tp_sangue = tp_sangue;
    }
}
