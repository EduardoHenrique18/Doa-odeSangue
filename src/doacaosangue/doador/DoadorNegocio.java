/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doacaosangue.doador;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author semnome
 */
public class DoadorNegocio implements InterfaceDoador {

    public void restricao(Doador doador) throws Exception {
        if (doador == null) {
            throw new Exception("Informar os dados do doador");
        }
        //Cpf_doador
        if (doador.getCpf_doador().length() != 11) {
            throw new Exception("O CPF do doador deverá possuir 11(onze) números");
        }
        if (!doador.getCpf_doador().matches("[0-9]+")) {
            throw new Exception("O CPF do doador deverá possuir apenas números");
        }
        //Nome
        if (doador.getNome() == null || doador.getNome().trim().equals("") == true) {
            throw new Exception("Informar o nome do doador");
        }
        if (doador.getNome().length() > 30) {
            throw new Exception("O nome do doador deverá ter menos de 30(trinta) caracteres");
        }
        //Endereço
        if (doador.getEndereco() == null || doador.getEndereco().trim().equals("") == true) {
            throw new Exception("Informar o endereço do doador");
        }
        if (doador.getEndereco().length() > 60) {
            throw new Exception("O endereço do doador deverá ter menos de 60(sessenta) caracteres");
        }
        //Sexo
        if (doador.getSexo() == null || doador.getSexo().trim().equals("") == true) {
            throw new Exception("Informar o sexo do doador");
        }
        if (!doador.getSexo().trim().equals("F") && !doador.getSexo().trim().equals("M")) {
            throw new Exception("Sexo Invalido");
        }
        //tipo sanguineo
        if (doador.getTp_sangue() == null || doador.getTp_sangue().trim().equals("") == true) {
            throw new Exception("Informar o tipo sanguíneo do doador");
        }
        if (!doador.getTp_sangue().trim().equals("A+") && !doador.getTp_sangue().trim().equals("A-")
                && !doador.getTp_sangue().trim().equals("B+") && !doador.getTp_sangue().trim().equals("B-")
                && !doador.getTp_sangue().trim().equals("AB+") && !doador.getTp_sangue().trim().equals("AB-")
                && !doador.getTp_sangue().trim().equals("O+") && !doador.getTp_sangue().trim().equals("O-")) {
            throw new Exception("Tipo sanguíneo invalido");
        }
    }

    @Override
    public void cadastrarDoador(Doador doador) throws SQLException, Exception {
        this.restricao(doador); //enviar o objeto para a camada de dados
        DoadorDAO dados = new DoadorDAO();
        dados.cadastrarDoador(doador);
    }

    @Override
    public void removerDoador(Doador doador) throws SQLException, Exception {
        if (doador.getCpf_doador().length() != 11) {
            throw new Exception("O CPF do doador deverá possuir 11(onze) números");
        }
        if (!doador.getCpf_doador().matches("[0-9]+")) {
            throw new Exception("O CPF do doador deverá possuir apenas números");
        }
        //enviar o objeto para a camada de dados
        DoadorDAO dados = new DoadorDAO();
        dados.removerDoador(doador);
    }

    @Override
    public void atualizarDoador(Doador doador) throws SQLException, Exception {
        //aplicar as validações
        this.restricao(doador);
        //enviar o objeto para a camada de dados
        DoadorDAO dados = new DoadorDAO();
        dados.atualizarDoador(doador);
    }

    @Override
    public ArrayList<Doador> listar(Doador filtro) throws Exception {
        DoadorDAO dados = new DoadorDAO();
        return dados.listar(filtro);
    }

    @Override
    public boolean loginDoador(String cpf) throws Exception {
        //Cpf
        if (cpf.length() != 11) {
            throw new Exception("O CPF do doador deverá ser possuir 11(onze) números");
        }
        if (!cpf.matches("[0-9]+")) {
            throw new Exception("O CPF do doador deverá possuir apenas números");
        }
        DoadorDAO dados = new DoadorDAO();
        return dados.loginDoador(cpf);
    }

    @Override
    public boolean verificaExistencia(Doador doador) throws Exception {
        return new DoadorDAO().verificaExistencia(doador);
    }

}
