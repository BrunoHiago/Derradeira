/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classes.DonoCasa;
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
public class DonoCasaDAO {
    private Connection conexao;
    
    public DonoCasaDAO(){
        this.conexao = ConexaoDAO.getConexao();
    }
    
    public void inserirDonoCasa(DonoCasa d){
        
        String msg = "insert into DonoCasa() values (?,?,?,?)";
        PreparedStatement ps;
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setString(1, d.getCpf());
            ps.setString(2, d.getNome());
            ps.setString(3, d.getTelefone());
            ps.setFloat(4, d.getRenda());
            
            if(!ps.execute()){
                System.out.println("Dono de Casa Inserido com sucesso");
            }else{
                System.out.println("Dono de Casa nao inserido");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonoCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void editarDonoCasa(DonoCasa d){
        
        String msg = "update DonoCasa set "
                + "nome = ?, "
                + "telefone = ?, "
                + "renda = ? "
                + "where cpf = ?";
        PreparedStatement ps;
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setString(4, d.getCpf());
            ps.setString(1, d.getNome());
            ps.setString(2, d.getTelefone());
            ps.setFloat(3, d.getRenda());
            
            if(!ps.execute()){
                System.out.println("Dono de Casa editado com sucesso");
            }else{
                System.out.println("Dono de Casa nao editado");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonoCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void removerDonoCasa(String cpf){
        
        String msg = "delete from DonoCasa where cpf = ?";
        PreparedStatement ps;
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setString(1,cpf);
            
            
            if(!ps.execute()){
                System.out.println("Dono de Casa removido com sucesso");
            }else{
                System.out.println("Dono de Casa nao removido");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonoCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ArrayList<DonoCasa> buscarDonoCasa(){
        
        String msg = "select * from DonoCasa";
        PreparedStatement ps;
        ArrayList<DonoCasa> list = new ArrayList();
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                DonoCasa d = new DonoCasa();
                
                d.setCpf(rs.getString("cpf"));
                d.setNome(rs.getString("nome"));
                d.setTelefone(rs.getString("telefone"));
                d.setRenda(rs.getFloat("renda"));
                
                list.add(d);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonoCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public DonoCasa buscarDonoCasaPorCpf(String cpf){
        
        String msg = "select * from DonoCasa where cpf = ?";
        PreparedStatement ps;
        DonoCasa d = null;
        
        try {
            ps = this.conexao.prepareStatement(msg);
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                d = new DonoCasa();
                
                d.setCpf(rs.getString("cpf"));
                d.setNome(rs.getString("nome"));
                d.setTelefone(rs.getString("telefone"));
                d.setRenda(rs.getFloat("renda"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DonoCasaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return d;
    }
    
    public boolean isExist(String cpf){
        return (this.buscarDonoCasaPorCpf(cpf)!=null);
    }
}
