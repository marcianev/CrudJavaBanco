/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.entidade;
import br.com.controle.CtrlAluno;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @author laboratorio
 */
public class ManterAlunoDAO extends DAO{   
    //metodo insert
    public void salvarAluno(CtrlAluno a) throws SQLException{
        try{
        abrirBanco();//abrir banco
        String sql = "INSERT INTO aluno (nome, email)"
                + "VALUE (?,?)";  
        pst = (PreparedStatement) con.prepareStatement(sql);//iniciar statement
        pst.setString(1, a.getNome());//blindar dados
        pst.setString(2, a.getEmail());
        pst.execute();  //executar
        fecharBanco(); //fechar banco
        
        }catch(Exception e){
        System.out.println("Erro"+e);
        }
    }//fim inserir
    
    //metodo update
    public void alterarAluno(CtrlAluno a) throws SQLException{
            
        try{
            abrirBanco();
            String sql = "UPDATE aluno set email =? WHERE cod = ?";
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setString(1, a.getNome());
            pst.setInt(2, a.getCod());
            pst.execute();
            fecharBanco();
        }catch(Exception e){
              System.out.println("Erro"+e);
        }   
    }//fim alterar
   
    //metodo delete
    public void deletarAluno(CtrlAluno a){
        try{
        abrirBanco();
        String sql = "DELETE from  aluno WHERE cod = ?"; 
        pst = (PreparedStatement) con.prepareStatement(sql);
        pst.setInt(1, a.getCod());
        pst.execute();
        fecharBanco();
        
        }catch(Exception e){
        System.out.println("Erro"+e);
        }
    }//fim deletar
    
    //metod select
    public void pesquisarAluno(CtrlAluno a){
        String sql = "SELECT email FROM aluno WHERE cod = ?";        
    }    
}//fim classe
