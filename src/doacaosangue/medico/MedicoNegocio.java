/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doacaosangue.medico;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author semnome
 */
public class MedicoNegocio implements InterfaceMedico {

    public void restricao(Medico medico) throws Exception {
        if (medico == null) {
            throw new Exception("Informar os dados do médico");
        }
        //Crm
        if (medico.getCrm().length() < 4 || medico.getCrm().length() > 10) {
            throw new Exception("O CRM do médico deverá possuir mais de 4 numeros e menos que 10");
        }
        if (!medico.getCrm().matches("[0-9]+")) {
            throw new Exception("O CRM do médico deverá possuir apenas números");
        }
        //Nome
        if (medico.getNome() == null || medico.getNome().trim().equals("") == true) {
            throw new Exception("Informar o nome do médico");
        }
        if (medico.getNome().length() > 30) {
            throw new Exception("O nome do médico deverá ter menos de 30(trinta) caracteres");
        }
        //Endereço
        if (medico.getEndereco() == null || medico.getEndereco().trim().equals("") == true) {
            throw new Exception("Informar o endereço do médico");
        }
        if (medico.getEndereco().length() > 60) {
            throw new Exception("O endereço do médico deverá ter menos de 60(sessenta) caracteres");
        }
    }

    @Override
    public void cadastrarMedico(Medico medico) throws SQLException, Exception {
        restricao(medico);
        //enviar o objeto para a camada de dados
        MedicoDAO dados = new MedicoDAO();
        dados.cadastrarMedico(medico);
    }

    @Override
    public void removerMedico(Medico medico) throws SQLException, Exception {
        if (medico.getCrm() == null || medico.getCrm().trim().equals("") == true) {
            throw new Exception("Informar os dados do medico");
        }
        //ADICIONAR UM IF = SE O CPF TIVER CADASTRADO PODE REMOVER
        //enviar o objeto para a camada de dados
        MedicoDAO dados = new MedicoDAO();
        dados.removerMedico(medico);
    }

    @Override
    public void atualizarMedico(Medico medico) throws SQLException, Exception {
        restricao(medico);
        //enviar o objeto para a camada de dados
        MedicoDAO dados = new MedicoDAO();
        dados.atualizarMedico(medico);
    }

    @Override
    public ArrayList<Medico> listar(Medico filtro) throws Exception {
        MedicoDAO dados = new MedicoDAO();
        return dados.listar(filtro);
    }

    @Override
    public boolean loginMedico(String crm) throws Exception {
        //Crm
        if (crm == null) {
            throw new Exception("CRM incorreto");
        } 
        if (crm.length() < 4 || crm.length() > 10) {
            throw new Exception("O CRM do médico deverá possuir mais de 4 numeros e menos que 10");
        }
        if (!crm.matches("[0-9]+")) {
            throw new Exception("O CRM do médico deverá possuir apenas números");
        }
        MedicoDAO dados = new MedicoDAO();
        return dados.loginMedico(crm);
    }
}
