/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.controle;
import br.com.entidade.DAO;

/**
 *
 * @author laboratorio
 */
public class CtrlAluno {
    //atributos
    private int cod;
    private String nome;
    private String email;
    private DAO conexao; 
    
    //setters

    public void setCod(int cod) {
        this.cod = cod;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    //getters

    public int getCod() {
        return cod;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }    
    
}
