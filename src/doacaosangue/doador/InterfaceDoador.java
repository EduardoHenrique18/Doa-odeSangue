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
public interface InterfaceDoador {

    void cadastrarDoador(Doador doador) throws SQLException, Exception;

    void removerDoador(Doador doador) throws SQLException, Exception;

    void atualizarDoador(Doador doador) throws SQLException, Exception;

    ArrayList<Doador> listar(Doador filtro) throws Exception;
    
    boolean loginDoador (String cpf) throws Exception;
    
    boolean verificaExistencia(Doador doador) throws Exception;
}
