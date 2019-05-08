/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doacaosangue.doador;

import doacaosangue.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author semnome
 */
public class DoadorDAO extends Conexao implements InterfaceDoador {

    @Override
    public void cadastrarDoador(Doador doador) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO doador (cpf_doador, nome, endereco, sexo, tipo_sangue) ";
        sql += " VALUES (?,?,?,?,?)";
        //preparando a instrução
        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, doador.getCpf_doador());
        preparedStatement.setString(2, doador.getNome());
        preparedStatement.setString(3, doador.getEndereco());
        preparedStatement.setString(4, doador.getSexo());
        preparedStatement.setString(5, doador.getTp_sangue());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public void removerDoador(Doador doador) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "DELETE FROM Doador WHERE cpf_doador = ? ";

        //preparando a instrução
        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, doador.getCpf_doador());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    @Override
    public void atualizarDoador(Doador doador) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "UPDATE doador SET nome = ?, endereco = ?, sexo = ?, tipo_sangue = ? WHERE cpf_doador = ?";
        //String sql = "update doador set nome = ?, endereco = ?, sexo = ?, tipo_sangue = ? where cpf_doador = ? ";
        //preparando a instrução

        PreparedStatement preparedStatement = super.conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, doador.getNome());
        preparedStatement.setString(2, doador.getEndereco());
        preparedStatement.setString(3, doador.getSexo());
        preparedStatement.setString(4, doador.getTp_sangue());
        preparedStatement.setString(5, doador.getCpf_doador());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        super.desconectar();
    }

    @Override
    public ArrayList<Doador> listar(Doador filtro) throws Exception {
        ArrayList<Doador> retorno = new ArrayList<>();

        int pos = 1;
        //instrução sql correspondente a inserção do aluno
        String sql = " select d.cpf_doador, d.nome, d.endereco, d.sexo, d.Tipo_Sangue";
        sql += " from doador as d ";
        sql += " Where d.cpf_doador IS NOT NULL ";

        if (filtro.getCpf_doador() != null && filtro.getCpf_doador().trim().equals("") == false) {
            sql += " and d.cpf_doador like ? ";
        }
        if (filtro.getNome() != null && filtro.getNome().trim().equals("") == false) {
            sql += " and d.nome like ? ";
        }
        if (filtro.getEndereco() != null && filtro.getEndereco().trim().equals("") == false) {
            sql += " and d.endereco like ? ";
        }
        if (filtro.getSexo() != null && filtro.getSexo().trim().equals("") == false) {
            sql += " and d.sexo like ? ";
        }
        if (filtro.getTp_sangue() != null && filtro.getTp_sangue().trim().equals("") == false) {
            sql += " and d.tipo_sangue like ? ";
        }
        //preparando a instrução
        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);

        if (filtro.getCpf_doador() != null && filtro.getCpf_doador().trim().equals("") == false) {
            preparedStatement.setString(pos, "%" + filtro.getCpf_doador() + "%");
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
            preparedStatement.setString(pos, "%" + filtro.getSexo() + "%");
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
            Doador d = new Doador();
            d.setCpf_doador(leitor.getString("cpf_doador"));
            d.setNome(leitor.getString("nome"));
            d.setEndereco(leitor.getString("endereco"));
            d.setSexo(leitor.getString("sexo"));
            d.setTp_sangue(leitor.getString("tipo_sangue"));
            retorno.add(d);
        }
        //fechando a conexão com o banco de dados
        super.desconectar();
        return retorno;
    }

    
    @Override
    public boolean loginDoador(String cpf) throws Exception {
        String query = "select cpf_doador from doador";

        boolean log = true;
        DoadorDAO md = new DoadorDAO();
        ResultSet rs = md.conectar().executeQuery(query);
        while (rs.next()) {
            if (rs.getString(1).equals(cpf)) {
                log = false;
                break;
            }
        }
        return log;
    }

    @Override
    public boolean verificaExistencia(Doador doador) throws Exception {
        boolean retorno = false;
        if (this.listar(doador).size() > 0) {
            retorno = true;
        }
        return retorno;
    }
    
}
