/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bruno
 */
public class VendaDAO {
    private Connection conexao;
    
    public VendaDAO(){
        this.conexao = ConexaoDAO.getConexao();
    }
    
    public void inserirVenda(Venda v){
        
        String msg = "insert into Venda() values (?,?,?,?,?)";
        PreparedStatement ps;
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setString(1, v.getCod());
            ps.setString(2, v.getFkCpf());
            ps.setInt(3, v.getFkCod());
            ps.setDate(4, java.sql.Date.valueOf(v.getDataVenda()));
            ps.setFloat(5, v.getValor());
            
            if(!ps.execute()){
                System.out.println("Venda Inserido com sucesso");
            }else{
                System.out.println("Venda nao inserido");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonoCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void editarVenda(Venda v){
        
        String msg = "update Venda set "
                + "fkCpf = ?, "
                + "fkCod = ?, "
                + "data = ?, "
                + "valor = ? "
                + "where cod = ?";
        PreparedStatement ps;
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setString(5, v.getCod());
            ps.setString(1, v.getFkCpf());
            ps.setInt(2, v.getFkCod());
            ps.setDate(3, java.sql.Date.valueOf(v.getDataVenda()));
            ps.setFloat(4, v.getValor());
            
            
            if(!ps.execute()){
                System.out.println("Venda editado com sucesso");
            }else{
                System.out.println("Venda nao editado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonoCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void removerVenda(String cod){
        
        String msg = "delete from Venda where cod = ?";
        PreparedStatement ps;
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setString(1,cod);
            
            
            if(!ps.execute()){
                System.out.println("Venda removido com sucesso");
            }else{
                System.out.println("Venda nao removido");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonoCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ArrayList<Venda> buscarVenda(){
        
        String msg = "select * from Venda";
        PreparedStatement ps;
        ArrayList<Venda> list = new ArrayList();
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Venda v = new Venda();
                
                v.setCod(rs.getString("cod"));
                v.setFkCpf(rs.getString("fkCpf"));
                v.setFkCod(rs.getInt("fkCod"));
                v.setDataVenda(rs.getDate("data").toLocalDate());
                v.setValor(rs.getFloat("valor"));
                
                list.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonoCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public Venda buscarVendaPorCpf(String cod){
        
        String msg = "select * from Venda where cod = ?";
        PreparedStatement ps;
        Venda v = null;
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setString(1, cod);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                v = new Venda();
                
                v.setCod(rs.getString("cod"));
                v.setFkCpf(rs.getString("fkCpf"));
                v.setFkCod(rs.getInt("fkCod"));
                v.setDataVenda(rs.getDate("data").toLocalDate());
                v.setValor(rs.getFloat("valor"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonoCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return v;
    }
    
    public boolean isExist(String cod){
        return (this.buscarVendaPorCpf(cod)!= null);
    }
    
    public float media(){
        String msg = "select AVG(valor) as media from Venda";
        PreparedStatement ps;
        float media = 0;
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                media = rs.getFloat("media");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonoCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return media;
    }
}
