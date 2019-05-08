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
public interface InterfaceMedico {

    void cadastrarMedico(Medico medico) throws SQLException, Exception;

    void removerMedico(Medico medico) throws SQLException, Exception;

    void atualizarMedico(Medico medico) throws SQLException, Exception;

    ArrayList<Medico> listar(Medico filtro) throws Exception;
    
    boolean loginMedico (String crm) throws Exception;
}
