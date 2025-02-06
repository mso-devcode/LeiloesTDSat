/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        conn = new conectaDAO().connectDB();
        
        if (conn !=  null) {
            try {
                String sql =  "insert into produtos (nome,valor,status)"
                    + "values (?,?,?)";
            
                prep =  conn.prepareStatement(sql);
                prep.setString(1, produto.getNome());
                prep.setDouble(2, produto.getValor());
                prep.setString(3, produto.getStatus());
                prep.execute();
                
                JOptionPane.showMessageDialog(null, "O Produto foi Cadastrado com Sucesso!");
                listagem.add(produto);
                System.out.println(listagem.size());
              
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(null, "ERRO: O Produto não foi Caastrado!");
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "BANCO DE DADOS ERRO!");
        }
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }

    
    
        
}

