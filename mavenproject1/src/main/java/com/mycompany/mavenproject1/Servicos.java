/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

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
 * @author 0068943
 */
public class Servicos {
    public List<Cliente> consultarAlunosGravados() {
        List<Cliente> retorno = new ArrayList<>();
        
        try {
            Connection c = Conexao.obterConexao();
            String sql = "SELECT * FROM arthur_ribeiro.cliente";
            PreparedStatement consulta = c.prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {                
                Cliente atual = new Cliente();
                atual.setNome(resultado.getString("nome"));
                atual.setEndereco(resultado.getString("endereco"));
                atual.setTelefone(resultado.getString("telefone"));
                atual.setEmail(resultado.getString("email"));
                retorno.add(atual);
            }
            c.close();
        } catch (SQLException ex) {
            System.err.println("SQL ERROR "+ ex.getMessage());
            Logger.getLogger(Servicos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }
    public void gravarAluno(Cliente dados) {
        try {
            String sql = "INSERT INTO arthur_ribeiro.cliente (nome, email, endereco, numeroTelefone) "
                    + "VALUES (?, ?, ?, ?)";
            
            Connection c = Conexao.obterConexao();
            PreparedStatement instrucao = c.prepareStatement(sql);
            instrucao.setString(1, dados.getNome());
            instrucao.setString(2, dados.getEmail());
            instrucao.setString(3, dados.getEndereco());
            instrucao.setString(4, dados.getTelefone());
            
            c.close();
        } catch (SQLException ex) {
            System.err.println("SQL ERROR "+ex.getMessage());
            Logger.getLogger(Servicos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
