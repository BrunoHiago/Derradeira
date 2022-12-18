/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import classes.Residencia;
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
public class ResidenciaDAO {
    private Connection conexao;
    
    public ResidenciaDAO(){
        this.conexao = ConexaoDAO.getConexao();
    }
    
    public void inserirResidencia(Residencia r){
        
        String msg = "insert into Residencia() values (?,?,?)";
        PreparedStatement ps;
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setInt(1, r.getCod());
            ps.setFloat(2, r.getArea());
            ps.setString(3, r.getEndereco());
            
            if(!ps.execute()){
                System.out.println("Residencia Inserido com sucesso");
            }else{
                System.out.println("Residencia nao inserido");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonoCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void editarResidencia(Residencia r){
        
        String msg = "update Residencia set "
                + "area = ?, "
                + "endereco = ? "
                + "where cod = ?";
        PreparedStatement ps;
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setInt(4, r.getCod());
            ps.setFloat(1, r.getArea());
            ps.setString(2, r.getEndereco());
            
            
            if(!ps.execute()){
                System.out.println("Residencia editado com sucesso");
            }else{
                System.out.println("Residencia nao editado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonoCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void removerResidencia(int id){
        
        String msg = "delete from Residencia where cod = ?";
        PreparedStatement ps;
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setInt(1,id);
            
            
            if(!ps.execute()){
                System.out.println("Residencia removido com sucesso");
            }else{
                System.out.println("Residencia nao removido");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonoCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ArrayList<Residencia> buscarResidencia(){
        
        String msg = "select * from Residencia";
        PreparedStatement ps;
        ArrayList<Residencia> list = new ArrayList();
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Residencia r = new Residencia();
                
                r.setCod(rs.getInt("cod"));
                r.setArea(rs.getFloat("area"));
                r.setEndereco(rs.getString("endereco"));
                
                list.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonoCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public Residencia buscarResidenciaPorCod(int id){
        
        String msg = "select * from Residencia where cod = ?";
        PreparedStatement ps;
        Residencia r = null;
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                r = new Residencia();
                
                r.setCod(rs.getInt("cod"));
                r.setArea(rs.getFloat("area"));
                r.setEndereco(rs.getString("endereco"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonoCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
    
    public ArrayList<Residencia> buscarResidencia(String endereco){
        
        String msg = "select * from Residencia where endereco = ?";
        PreparedStatement ps;
        ArrayList<Residencia> list = new ArrayList();
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setString(1, endereco);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Residencia r = new Residencia();
                
                r.setCod(rs.getInt("cod"));
                r.setArea(rs.getFloat("area"));
                r.setEndereco(rs.getString("endereco"));
                
                list.add(r);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonoCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public boolean isExist(int id){
        return (this.buscarResidenciaPorCod(id)!= null);
    }
}
