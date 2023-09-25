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
    
    public List<Cliente> consultaCliente(){
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
                atual.setTelefone(resultado.getString("numeroTelefone"));
                atual.setEmail(resultado.getString("email"));
                atual.setIdentificador(resultado.getInt("identificardor"));
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
            String sql="INSERT INTO arthur_ribeiro.CLIENTE(nome,email,endereco,numeroTelefone) "
                    + " VALUES (?,?,?,?);";
            PreparedStatement insercao = c.prepareStatement(sql);
            insercao.setString(1, dados.getNome() );
            insercao.setString(2, dados.getEmail());
            insercao.setString(3,dados.getEndereco());
            insercao.setInt(4,Integer.parseInt(dados.getTelefone()));
            insercao.executeQuery();
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ServicosAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Cliente consultaCliente(String identificador) {
        try {
            Connection c = Conexao.obeterConexao();
            String sql="SELECT * FROM arthur_ribeiro.CLIENTE"
                    + " WHERE identificardor = ?";
            PreparedStatement consulta = c.prepareStatement(sql);
            consulta.setInt(1, Integer.parseInt(identificador));
            ResultSet rs = consulta.executeQuery();
            
            if(rs.next()) {
                Cliente  cliente = new Cliente();
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("numeroTelefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setIdentificador(rs.getInt("identificardor"));
                return cliente;
            }else {
                return null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        
    }
}
