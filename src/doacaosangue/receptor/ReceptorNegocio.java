/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doacaosangue.receptor;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author semnome
 */
public class ReceptorNegocio implements InterfaceReceptor {

    public void restricao(Receptor receptor) throws Exception {
        if (receptor == null) {
            throw new Exception("Informar os dados do receptor");
        }
        //Cpf_doador
        if (receptor.getCpf_receptor().length() != 11) {
            throw new Exception("O CPF do receptor deverá possuir 11(onze) números");
        }
        if (!receptor.getCpf_receptor().matches("[0-9]+")) {
            throw new Exception("O CPF do receptor deverá possuir apenas números");
        }
        //Nome
        if (receptor.getNome() == null || receptor.getNome().trim().equals("") == true) {
            throw new Exception("Informar o nome do receptor");
        }
        if (receptor.getNome().length() > 30) {
            throw new Exception("O nome do receptor deverá ter menos de 30(trinta) caracteres");
        }
        //Endereço
        if (receptor.getEndereco() == null || receptor.getEndereco().trim().equals("") == true) {
            throw new Exception("Informar o endereço do receptor");
        }
        if (receptor.getEndereco().length() > 60) {
            throw new Exception("O endereço do receptor deverá ter menos de 60(sessenta) caracteres");
        }
        //Sexo
        if (receptor.getSexo() == null || receptor.getSexo().trim().equals("") == true) {
            throw new Exception("Informar o sexo do receptor");
        }
        if (!receptor.getSexo().trim().equals("F") && !receptor.getSexo().trim().equals("M")) {
            throw new Exception("Sexo Invalido");
        }
        //tipo sanguineo
        if (receptor.getTp_sangue() == null || receptor.getTp_sangue().trim().equals("") == true) {
            throw new Exception("Informar o tipo sanguíneo do receptor");
        }
        if (!receptor.getTp_sangue().trim().equals("A+") && !receptor.getTp_sangue().trim().equals("A-")
                && !receptor.getTp_sangue().trim().equals("B+") && !receptor.getTp_sangue().trim().equals("B-")
                && !receptor.getTp_sangue().trim().equals("AB+") && !receptor.getTp_sangue().trim().equals("AB-")
                && !receptor.getTp_sangue().trim().equals("O+") && !receptor.getTp_sangue().trim().equals("O-")) {
            throw new Exception("Tipo sanguíneo invalido");
        }
    }

    @Override
    public void cadastrarReceptor(Receptor receptor) throws SQLException, Exception {
        this.restricao(receptor);
        //enviar o objeto para a camada de dados
        ReceptorDAO dados = new ReceptorDAO();
        dados.cadastrarReceptor(receptor);
    }

    @Override
    public void removerReceptor(Receptor receptor) throws SQLException, Exception {
        //Cpf_doador
        if (receptor.getCpf_receptor().length() != 11) {
            throw new Exception("O CPF do receptor deverá possuir 11(onze) números");
        }
        if (!receptor.getCpf_receptor().matches("[0-9]+")) {
            throw new Exception("O CPF do receptor deverá possuir apenas números");
        }
        //enviar o objeto para a camada de dados
        ReceptorDAO dados = new ReceptorDAO();
        dados.removerReceptor(receptor);
    }

    @Override
    public void atualizarReceptor(Receptor receptor) throws SQLException, Exception {
        this.restricao(receptor);
        //enviar o objeto para a camada de dados
        ReceptorDAO dados = new ReceptorDAO();
        dados.atualizarReceptor(receptor);
    }

    @Override
    public ArrayList<Receptor> listar(Receptor filtro) throws Exception {      
        ReceptorDAO dados = new ReceptorDAO();
        return dados.listar(filtro);
    }

    @Override
    public boolean loginReceptor(String cpf) throws Exception {
        //Cpf
        if (cpf.length() != 11) {
            throw new Exception("O CPF do receptor deverá ser possuir 11(onze) números");
        }
        if (!cpf.matches("[0-9]+")) {
            throw new Exception("O CPF do receptor deverá possuir apenas números");
        }
        ReceptorDAO dados = new ReceptorDAO();
        return dados.loginReceptor(cpf);
    }

    @Override
    public boolean verificaExistencia(Receptor receptor) throws Exception {
        return new ReceptorDAO().verificaExistencia(receptor);
    }

}
