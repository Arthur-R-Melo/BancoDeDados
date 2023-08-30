/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javaandpgsql.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author janio.silva
 */
public class Conexao {

    public static Connection obeterConexao() {
        try {
            String url = "jdbc:postgresql://10.90.24.56:5432/aula";
            String usuario = "aula";
            String senha = "aula";

            Connection con = DriverManager.getConnection(url, usuario, senha);
            return con;
        } catch (java.sql.SQLException ex) {
            System.out.println("Erro ao conectar no banco: "+ex.getMessage());
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
