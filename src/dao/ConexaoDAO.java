/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class ConexaoDAO {
    public static Connection getConexao(){
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/Prova03","root","123456789");
        } catch (SQLException ex) {
            Logger.getLogger("Erro ao conectar: "+ex.toString());
        }
        
        return conexao;
    }
}
