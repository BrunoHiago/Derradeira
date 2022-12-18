/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author bruno
 */
public class Residencia {
    private int cod;
    private float area;
    private String endereco;

    public Residencia(int cod, float area, String endereco) {
        this.cod = cod;
        this.area = area;
        this.endereco = endereco;
    }
    
    public Residencia() {
        this.cod = -1;
        this.area = -1;
        this.endereco = "Sem Endereço";
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Residencia{" 
                + "cod = " + cod
                + ", area = " + area
                + ", endereco = " + endereco + '}';
    }
    
    
}
