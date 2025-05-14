/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.entidade;

import br.com.controle.Notas;
import java.sql.SQLException;
import java.sql.PreparedStatement;
/**
 *
 * @author laboratorio
 */
public class ManterNotas extends DAO{
    public void salvarNota(Notas n) throws SQLException{
        try{
            abrirBanco();
            String sql = "INSERT INTO semestre (id_aluno, nota1, nota2, media)"
                    + "values(?, ?, ?, ?)";
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, n.getCod_aluno());
            pst.setDouble(2, n.getNota1());
            pst.setDouble(3, n.getNota2());
            pst.setDouble(4, n.getMedia());
            pst.execute();
            fecharBanco();
        }catch(Exception e){
            System.out.println("Erro:"+e);
        }//try
    }//fecha salvarNota   
    
    public void deletarNota(Notas n)throws SQLException{
        try{
            abrirBanco();
            String sql = "DELETE FROM semestre Where cod = ?";
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, n.getCod());
            pst.execute();
            fecharBanco();
        }catch(Exception e){
            System.out.println("Erro:"+e);
        }
    }
}//fecha classe
