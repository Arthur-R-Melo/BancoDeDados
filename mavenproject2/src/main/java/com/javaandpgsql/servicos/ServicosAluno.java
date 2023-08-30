/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javaandpgsql.servicos;

import com.javaandpgsql.conexao.Cliente;
import com.javaandpgsql.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author janio.silva
 */
public class ServicosAluno {
    
    public List<Cliente> consultarAlunosGravados(){
        try {
            List<Cliente> retorno=new ArrayList<Cliente>();
            Connection c = Conexao.obeterConexao();
            String sql="SELECT * FROM arthur_ribeiro.CLIENTE";
            PreparedStatement consulta= c.prepareStatement(sql);
            ResultSet resultado=consulta.executeQuery();
            while(resultado.next()){
                Cliente atual=new Cliente();
                atual.setNome(resultado.getString("nome"));
                atual.setEndereco(resultado.getString("endereco"));
                atual.setTelefone(resultado.getString("telefone"));
                atual.setEmail(resultado.getString("email"));
                retorno.add(atual);
                System.out.println(atual);
            }
            c.close();
            return retorno;
        } catch (SQLException ex) {
            Logger.getLogger(ServicosAluno.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro: "+ex.getMessage());
            return null;
        }
    }
    
    public void gravarAluno(Cliente dados){
        try {
            Connection c = Conexao.obeterConexao();
            String sql="INSERT INTO arthur_ribeiro.CLIENTE(nome,email,endereco,telefone) "
                    + " VALUES (?,?,?,?);";
            PreparedStatement insercao = c.prepareStatement(sql);
            insercao.setString(1, dados.getNome() );
            insercao.setString(2, dados.getEmail());
            insercao.setString(3,dados.getEndereco());
            insercao.setString(4,dados.getTelefone());
            insercao.executeQuery();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicosAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
