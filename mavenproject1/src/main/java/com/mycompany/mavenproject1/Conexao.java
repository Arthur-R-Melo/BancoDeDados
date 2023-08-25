/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 0068943
 */
public class Conexao {
    private static Connection ifConexoes;
    private static String url = "jdbc.postgresql://10.90.24.56/aula";
    private static String usuario = "aula";
    private static String senha = "aula";
    
    public Connection obterConexao() {
        try {
            Class.forName("org.postgresql.Driver");
            
            ifConexoes = DriverManager.getConnection(url, usuario, senha);
            
            System.out.println("Deu certo");
        } catch (ClassNotFoundException ex) {
            System.err.println("Classe não encontrada"+ex.getMessage());
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.err.println("SQL ERROR"+ex.getMessage());
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ifConexoes;
    }
}
