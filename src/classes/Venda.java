/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.time.LocalDate;

/**
 *
 * @author bruno
 */
public class Venda {
    private String cod;
    private String fkCpf;
    private int fkCod;
    private LocalDate dataVenda;
    private float valor;

    public Venda(String cod, String fkCpf, int fkCod, LocalDate dataVenda, float valor) {
        this.cod = cod;
        this.fkCpf = fkCpf;
        this.fkCod = fkCod;
        this.dataVenda = dataVenda;
        this.valor = valor;
    }
    
    public Venda() {
        this.cod = "Sem codigo";
        this.fkCpf = "Sem CPF";
        this.fkCod = -1;
        this.dataVenda = LocalDate.now();
        this.valor = -1;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getFkCpf() {
        return fkCpf;
    }

    public void setFkCpf(String fkCpf) {
        this.fkCpf = fkCpf;
    }

    public int getFkCod() {
        return fkCod;
    }

    public void setFkCod(int fkCod) {
        this.fkCod = fkCod;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Venda{" 
                + "cod = " + cod
                + ", fkCpf = " + fkCpf
                + ", fkCod = " + fkCod
                + ", dataVenda = " + dataVenda
                + ", valor = " + valor + '}';
    }
    
    
}
