/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doacaosangue.medico;

import doacaosangue.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author semnome
 */
public class MedicoDAO extends Conexao implements InterfaceMedico {

    @Override
    public void cadastrarMedico(Medico medico) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO Medico (crm, nome, endereco) ";
        sql += " VALUES (?,?,?)";
        //preparando a instrução
        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, medico.getCrm());
        preparedStatement.setString(2, medico.getNome());
        preparedStatement.setString(3, medico.getEndereco());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public void removerMedico(Medico medico) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "DELETE FROM Medico WHERE crm = ? ";

        //preparando a instrução
        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, medico.getCrm());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public void atualizarMedico(Medico medico) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "UPDATE Medico SET nome = ?, endereco = ? WHERE crm = ? ";
        //preparando a instrução

        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, medico.getNome());
        preparedStatement.setString(2, medico.getEndereco());
        preparedStatement.setString(3, medico.getCrm());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public ArrayList<Medico> listar(Medico filtro) throws Exception {
        ArrayList<Medico> retorno = new ArrayList<>();

        int pos = 1;
        //instrução sql correspondente a inserção do aluno
        String sql = " select m.crm, m.nome , m.endereco ";
        sql += " from Medico as m ";
        sql += " Where m.crm IS NOT NULL ";

        if (filtro.getCrm() != null && filtro.getCrm().trim().equals("") == false) {
            sql += " and m.crm like ? ";
        }
        if (filtro.getNome() != null && filtro.getNome().trim().equals("") == false) {
            sql += " and m.nome like ? ";
        }
        if (filtro.getEndereco() != null && filtro.getEndereco().trim().equals("") == false) {
            sql += " and m.endereco like ? ";
        }
        //preparando a instrução
        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);

        if (filtro.getCrm() != null && filtro.getCrm().trim().equals("") == false) {
            preparedStatement.setString(pos, "%" + filtro.getCrm() + "%");
            pos++;
        }
        if (filtro.getNome() != null && filtro.getNome().trim().equals("") == false) {
            preparedStatement.setString(pos, "%" + filtro.getNome() + "%");
            pos++;
        }
        if (filtro.getEndereco() != null && filtro.getEndereco().trim().equals("") == false) {
            preparedStatement.setString(pos, "%" + filtro.getEndereco() + "%");
            pos++;
        }
        //executando a instrução sql
        ResultSet leitor = preparedStatement.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Medico m = new Medico();
            m.setCrm(leitor.getString("crm"));
            m.setNome(leitor.getString("nome"));
            m.setEndereco(leitor.getString("endereco"));
            retorno.add(m);
        }
        //fechando a conexão com o banco de dados
        desconectar();
        return retorno;
    }

    @Override
    public boolean loginMedico(String crm) throws Exception {
        String query = "select crm from medico";

        boolean log = true;
        MedicoDAO md = new MedicoDAO();
        ResultSet rs = md.conectar().executeQuery(query);
        while (rs.next()) {
            if (rs.getString(1).equals(crm)) {
                log = false;
                break;
            }
        }
        return log;
    }
}
