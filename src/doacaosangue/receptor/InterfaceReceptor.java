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
public interface InterfaceReceptor {

    void cadastrarReceptor(Receptor receptor) throws SQLException, Exception;

    void removerReceptor(Receptor receptor) throws SQLException, Exception;

    void atualizarReceptor(Receptor receptor) throws SQLException, Exception;

    ArrayList<Receptor> listar(Receptor filtro) throws Exception;
    
    boolean loginReceptor (String cpf) throws Exception;
    
    boolean verificaExistencia(Receptor receptor) throws Exception;
}
