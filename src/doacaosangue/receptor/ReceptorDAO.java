/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doacaosangue.receptor;

import doacaosangue.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author semnome
 */
public class ReceptorDAO extends Conexao implements InterfaceReceptor {

    @Override
    public void cadastrarReceptor(Receptor receptor) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO receptor (cpf_receptor, nome, endereco, sexo, Tipo_Sangue ) ";
        sql += " VALUES (?,?,?,?,?)";
        //preparando a instrução
        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, receptor.getCpf_receptor());
        preparedStatement.setString(2, receptor.getNome());
        preparedStatement.setString(3, receptor.getEndereco());
        preparedStatement.setString(4, receptor.getSexo());
        preparedStatement.setString(5, receptor.getTp_sangue());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public void removerReceptor(Receptor receptor) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "DELETE FROM Receptor WHERE cpf_receptor = ? ";

        //preparando a instrução
        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, receptor.getCpf_receptor());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public void atualizarReceptor(Receptor receptor) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "UPDATE Receptor SET nome = ?, endereco = ?, sexo = ?, tipo_sangue = ? WHERE cpf_receptor = ? ";
        //preparando a instrução

        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, receptor.getNome());
        preparedStatement.setString(2, receptor.getEndereco());
        preparedStatement.setString(3, receptor.getSexo());
        preparedStatement.setString(4, receptor.getTp_sangue());
        preparedStatement.setString(5, receptor.getCpf_receptor());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public ArrayList<Receptor> listar(Receptor filtro) throws Exception {
        ArrayList<Receptor> retorno = new ArrayList<>();

        int pos = 1;
        //instrução sql correspondente a inserção do aluno
        String sql = " select r.cpf_receptor, r.nome , r.endereco, r.sexo, r.Tipo_Sangue ";
        sql += " from Receptor as r ";
        sql += " Where r.cpf_receptor IS NOT NULL ";

        if (filtro.getCpf_receptor() != null && filtro.getCpf_receptor().trim().equals("") == false) {
            sql += " and r.cpf_receptor like ? ";
        }
        if (filtro.getNome() != null && filtro.getNome().trim().equals("") == false) {
            sql += " and r.nome like ? ";
        }
        if (filtro.getEndereco() != null && filtro.getEndereco().trim().equals("") == false) {
            sql += " and r.endereco like ? ";
        }
        if (filtro.getSexo() != null && filtro.getSexo().trim().equals("") == false) {
            sql += " and r.sexo like ? ";
        }
        if (filtro.getTp_sangue() != null && filtro.getTp_sangue().trim().equals("") == false) {
            sql += " and r.tipo_sangue like ? ";
        }

        //preparando a instrução
        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);

        if (filtro.getCpf_receptor() != null && filtro.getCpf_receptor().trim().equals("") == false) {
            preparedStatement.setString(pos, "%" + filtro.getCpf_receptor() + "%");
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
        if (filtro.getSexo() != null && filtro.getSexo().trim().equals("") == false) {
            preparedStatement.setString(pos, "%" + filtro.getEndereco() + "%");
            pos++;
        }
        if (filtro.getTp_sangue() != null && filtro.getTp_sangue().trim().equals("") == false) {
            preparedStatement.setString(pos, "%" + filtro.getTp_sangue() + "%");
            pos++;
        }
        //executando a instrução sql
        ResultSet leitor = preparedStatement.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Receptor r = new Receptor();
            r.setCpf_receptor(leitor.getString("cpf_receptor"));
            r.setNome(leitor.getString("nome"));
            r.setEndereco(leitor.getString("endereco"));
            r.setSexo(leitor.getString("sexo"));
            r.setTp_sangue(leitor.getString("tipo_sangue"));
            retorno.add(r);
        }
        //fechando a conexão com o banco de dados
        desconectar();
        return retorno;
    }

    @Override
    public boolean loginReceptor(String cpf) throws Exception {
        String query = "select cpf_receptor from receptor";

        boolean log = true;
        ReceptorDAO rd = new ReceptorDAO();
        ResultSet rs = rd.conectar().executeQuery(query);
        while (rs.next()) {
            if (rs.getString(1).equals(cpf)) {
                log = false;
                break;
            }
        }
        return log;
    }

    @Override
    public boolean verificaExistencia(Receptor receptor) throws Exception {
        boolean retorno = false;
        if (this.listar(receptor).size() > 0) {
            retorno = true;
        }
        return retorno;
    }
}
