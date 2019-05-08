/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doacaosangue.doacao;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author semnome
 */
public interface InterfaceDoacao {

    void cadastrarDoacao(Doacao doacao) throws SQLException, Exception;

    void removerDoacao(Doacao doacao) throws SQLException, Exception;

    void atualizarDoacao(Doacao doacao) throws SQLException, Exception;

    ArrayList<Doacao> listar(Doacao filtro) throws Exception;
    
}
