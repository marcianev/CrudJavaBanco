/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.entidade;

import br.com.controle.Notas;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
/**
 *
 * @author laboratorio
 */
public class ManterNotas extends DAO{
    public void salvarNota(Notas n) throws SQLException{
        try{
            abrirBanco();
            String sql = "INSERT INTO nota (cod_aluno, nota1, nota2)"
                    + "values(?, ?, ?)";
            pst = (PreparedStatement) con.prepareStatement(sql);
            pst.setInt(1, n.getCod_aluno());
            pst.setDouble(2, n.getNota1());
            pst.setDouble(3, n.getNota2());           
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
    
    public List<Media> procedureMedia() throws SQLException{
        List<Media> medias = new ArrayList<>();
        try{
            abrirBanco();
            String sql = "CALL selecionar_media()";
            pst = (PreparedStatement) con.prepareStatement(sql);           
            ResultSet rs = pst.executeQuery();
            
            while (rs.next()){            
            String nome = rs.getString("nome");
            double nota1 = rs.getDouble("nota1");
            double nota2 = rs.getDouble("nota2");
            double media = rs.getDouble("media");
            
            medias.add(new Media(nome, nota1, nota2, media));
                             
        }
             rs.close();
            fecharBanco();  
        }catch(Exception e){}
        return medias;
    }//fecha listar
}//fecha classe
