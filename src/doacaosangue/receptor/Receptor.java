/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doacaosangue.receptor;

import doacaosangue.doacao.Doacao;
import java.util.ArrayList;

/**
 *
 * @author semnome
 */
public class Receptor {

    private String cpf_receptor;
    private String nome;
    private String endereco;
    private String sexo;
    private String tp_sangue;

    private ArrayList<Doacao> doacao;

    public Receptor() {
        this.doacao = new ArrayList<Doacao>();
    }

    /**
     * @return the cpf_receptor
     */
    public String getCpf_receptor() {
        return cpf_receptor;
    }

    /**
     * @param cpf_receptor the cpf_receptor to set
     */
    public void setCpf_receptor(String cpf_receptor) {
        this.cpf_receptor = cpf_receptor;
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
