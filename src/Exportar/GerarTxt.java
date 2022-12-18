/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exportar;

import classes.DonoCasa;
import classes.Residencia;
import classes.Venda;
import dao.DonoCasaDAO;
import dao.ResidenciaDAO;
import dao.VendaDAO;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author bruno
 */
public class GerarTxt {
    public static void gerandoTxt() throws IOException{
        VendaDAO conexao = new VendaDAO();
        DonoCasaDAO cdc = new DonoCasaDAO();
        ResidenciaDAO cr = new ResidenciaDAO();
        
        ArrayList<Venda> listV = conexao.buscarVenda();
        ArrayList<DonoCasa> listD = cdc.buscarDonoCasa();
        ArrayList<Residencia> listR = cr.buscarResidencia();
        
        try (BufferedWriter br = new BufferedWriter(new FileWriter("DadosBanco.txt"))) {
            br.write("Dados do Donos de Casa");
            br.newLine();
            br.newLine();
            for(DonoCasa d : listD){
                br.write(d.toString());
                br.newLine();
            }
            br.newLine();
            br.newLine();
            br.newLine();
            
            br.write("Dados da Residencia");
            br.newLine();
            br.newLine();
            for(Residencia r : listR){
                br.write(r.toString());
                br.newLine();
            }
            
            br.newLine();
            br.newLine();
            br.newLine();
            
            br.write("Dados da Venda");
            br.newLine();
            br.newLine();
            for(Venda v : listV){
                br.write(v.toString());
                br.newLine();
            }
            
            System.out.println("Dados salvo no Txt com Sucesso");
        }
    }
}
