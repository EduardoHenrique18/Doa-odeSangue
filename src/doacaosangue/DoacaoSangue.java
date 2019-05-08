/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doacaosangue;

import doacaosangue.conexao.Conexao;
import doacaosangue.doador.Doador;
import doacaosangue.doador.DoadorDAO;
import doacaosangue.doador.DoadorNegocio;
import doacaosangue.medico.Medico;
import doacaosangue.medico.MedicoNegocio;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author semnome
 */
public class DoacaoSangue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Doador d = new Doador();
        d.setCpf_doador("12345678912");
        d.setEndereco("rua tal");
        d.setNome("jurema");
        d.setSexo("F");
        d.setTp_sangue("A+");
        DoadorDAO dd = new DoadorDAO();
        System.out.println(dd.listar(d));
        /*Medico m = new Medico();
        m.setCrm("1234567891234566");
        m.setEndereco("rua lala");
        m.setNome("cleber");
        MedicoNegocio mn = new MedicoNegocio();
        mn.cadastrarMedico(m);*/
    }

}
