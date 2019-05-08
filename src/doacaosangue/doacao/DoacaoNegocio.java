/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doacaosangue.doacao;

import doacaosangue.doador.Doador;
import doacaosangue.doador.DoadorNegocio;
import doacaosangue.medico.Medico;
import doacaosangue.medico.MedicoNegocio;
import doacaosangue.receptor.Receptor;
import doacaosangue.receptor.ReceptorNegocio;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author semnome
 */
public class DoacaoNegocio implements InterfaceDoacao {

    @Override
    public void cadastrarDoacao(Doacao doacao) throws SQLException, Exception {
        if (doacao == null) {
            throw new Exception("Informar os dados da doacao");
        }
        if (doacao.getMedico().getCrm().length() < 4 || doacao.getMedico().getCrm().length() > 10) {
            throw new Exception("O CRM do médico deverá possuir mais de 4 numeros e menos que 10");
        }
        if (!doacao.getMedico().getCrm().matches("[0-9]+")) {
            throw new Exception("O CRM do médico deverá possuir apenas números");
        }
        if (doacao.getDoador().getCpf_doador().length() != 11) {
            throw new Exception("O CPF do doador deverá possuir 11(onze) números");
        }
        if (!doacao.getDoador().getCpf_doador().matches("[0-9]+")) {
            throw new Exception("O CPF do doador deverá possuir apenas números");
        }
        if (doacao.getReceptor().getCpf_receptor().length() != 11) {
            throw new Exception("O CPF do receptor deverá possuir 11(onze) números");
        }
        if (!doacao.getReceptor().getCpf_receptor().matches("[0-9]+")) {
            throw new Exception("O CPF do receptor deverá possuir apenas números");
        }
        DoacaoDAO dados = new DoacaoDAO();
        dados.cadastrarDoacao(doacao);
    }

    @Override
    public void removerDoacao(Doacao doacao) throws SQLException, Exception {
        DoacaoDAO dados = new DoacaoDAO();
        dados.removerDoacao(doacao);
    }

    @Override
    public void atualizarDoacao(Doacao doacao) throws SQLException, Exception {
        DoacaoDAO dados = new DoacaoDAO();
        dados.atualizarDoacao(doacao);
    }

    @Override
    public ArrayList<Doacao> listar(Doacao filtro) throws Exception {
        DoacaoDAO dados = new DoacaoDAO();
        return dados.listar(filtro);
    }

}
