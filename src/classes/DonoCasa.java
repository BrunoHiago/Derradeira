/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

/**
 *
 * @author bruno
 */
public class DonoCasa implements Comparable{
    private String cpf;
    private String nome;
    private String telefone;
    private float renda;

    public DonoCasa(String cpf, String nome, String telefone, float renda) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.renda = renda;
    }
    
    public DonoCasa() {
        this.cpf = "Sem CPF";
        this.nome = "Sem Nome";
        this.telefone = "Sem Telefone";
        this.renda = -1;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public float getRenda() {
        return renda;
    }

    public void setRenda(float renda) {
        this.renda = renda;
    }

    @Override
    public String toString() {
        return "DonoCasa{" + "cpf = " + cpf + 
                ", nome = " + nome + 
                ", telefone = " + telefone + 
                ", renda = " + renda + '}';
    }

    @Override
    public int compareTo(Object o) {
        return this.getNome().compareTo(((DonoCasa)o).getNome());
    }
    
    
}
