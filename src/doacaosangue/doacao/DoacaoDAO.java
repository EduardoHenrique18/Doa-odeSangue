/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doacaosangue.doacao;

import doacaosangue.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class DoacaoDAO extends Conexao implements InterfaceDoacao {

    @Override
    public void cadastrarDoacao(Doacao doacao) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "INSERT INTO doacao (dt_doacao,crm,cpf_doador,cpf_receptor) ";
        sql += " VALUES (?,?,?,?)";
        //preparando a instrução
        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setString(1, doacao.getDt_doacao());
        preparedStatement.setString(2, doacao.getMedico().getCrm());
        preparedStatement.setString(3, doacao.getDoador().getCpf_doador());
        preparedStatement.setString(4, doacao.getReceptor().getCpf_receptor());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public void removerDoacao(Doacao doacao) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "DELETE FROM Doacao WHERE cd_doacao = ? ";

        //preparando a instrução
        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);
        //passando os valores para os parametros
        preparedStatement.setInt(1, doacao.getCd_doacao());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public void atualizarDoacao(Doacao doacao) throws SQLException, Exception {
        //instrucao a ser executada
        String sql = "UPDATE Doacao SET crm = ?, cpf_doador = ?, cpf_receptor = ? WHERE cd_doacao = ? ";
        //preparando a instrução

        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);
        //passando os valores para os parametro        
        preparedStatement.setString(1, doacao.getMedico().getCrm());
        preparedStatement.setString(2, doacao.getDoador().getCpf_doador());
        preparedStatement.setString(3, doacao.getReceptor().getCpf_receptor());
        preparedStatement.setInt(4, doacao.getCd_doacao());
        // execute insert SQL stetement
        preparedStatement.executeUpdate();
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public ArrayList<Doacao> listar(Doacao filtro) throws Exception {

        ArrayList<Doacao> retorno = new ArrayList<>();

        int pos = 1;
        //instrução sql correspondente a inserção do aluno
        String sql = "select d.cd_doacao, d.dt_doacao, \n" +
"mm.nome as nomemedico ,mm.crm,  \n" +
"dd.nome as nomedoador,dd.cpf_doador,\n" +
"r.nome as nomereceptor,r.cpf_receptor  \n" +
"from doacao\n" +
"as d inner join medico as mm on d.crm = mm.crm\n" +
"inner join doador as dd on d.cpf_doador = dd.cpf_doador \n" +
"inner join receptor as r on d.cpf_receptor = r.cpf_receptor \n" +
"where d.cd_doacao > 0";

        //preparando a instrução
        PreparedStatement preparedStatement = conectarParametros().prepareStatement(sql);

        //executando a instrução sql
        ResultSet leitor = preparedStatement.executeQuery();
        //lendo os resultados
        while (leitor.next()) {
            Doacao d = new Doacao();
            d.setCd_doacao(leitor.getInt("cd_doacao"));
            d.setDt_doacao(leitor.getString("dt_doacao"));
            d.getMedico().setCrm(leitor.getString("crm"));   
            d.getMedico().setNome(leitor.getString("nomemedico"));
            d.getDoador().setCpf_doador(leitor.getString("cpf_doador"));
            d.getDoador().setNome(leitor.getString("nomedoador"));
            d.getReceptor().setCpf_receptor(leitor.getString("cpf_receptor"));
            d.getReceptor().setNome(leitor.getString("nomereceptor"));
            retorno.add(d);
        }
        //fechando a conexão com o banco de dados
        desconectar();
        return retorno;

    }
}
