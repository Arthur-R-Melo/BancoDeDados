/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author 0068943
 */
public class Servicos {
    public void gravarAluno(Aluno dados) {
        String sql = "INSERT INTO janio.ALUNO (nome, email, endereco, telefone, cpf) "
                + "VALUES (?, ?, ?, ?, ?)";
        
        Connection c = Conexao.obterConexao();
        PreparedStatement instrucao = c.prepareStatement(sql);
    }
}
