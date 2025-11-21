/*
    Atividade 02:
    Projetista: Fabricio Ramos Malvar Cabral CPF 025.885.415-42
    
    Versão: 1.1     Data: 20/11/2025

    Objetivo:
    1. Criação da conexão e desconexão do software com o banco de dados.
    2. Criação de instruções Inclusão, Consulta, Atualização, Exclusão 
    
*/

package view;

import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProdutosDAO {
    
    Connection          conn;
    PreparedStatement   prep;
    ResultSet           resultset;
        
    
    
    private conectaDAO dao;
    
    public void cadastrarProduto (ProdutosDTO produto){
                
        conn = new conectaDAO().connectDB();
               
        try 
        {
            prep = conn.prepareStatement("INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)");
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            
            //Atualizar o banco de dados    
            prep.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Dados incluidos com sucesso");
            
            conn.close();
            
            
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,"Erro ao conectar: " + ex.getMessage());
            //System.out.println("Erro ao conectar: " + ex.getMessage());
            // return ex.getErrorCode();
        }
        
                      
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        conn = new conectaDAO().connectDB();
        
        String sql = "SELECT * FROM produtos";
        
        try 
        {
            PreparedStatement prep = this.conn.prepareStatement(sql);
            
            ResultSet resultset = prep.executeQuery();
            
            ArrayList<ProdutosDTO> listagem = new ArrayList<>();
            
            while (resultset.next()) 
            { //.next retorna verdadeiro caso exista uma próxima posição dentro do array
                
                ProdutosDTO produtos = new ProdutosDTO();
                
                produtos.setId(resultset.getInt("id"));
                produtos.setNome(resultset.getString("nome"));
                produtos.setValor(resultset.getInt("valor"));
                produtos.setStatus(resultset.getString("status"));
                
                listagem.add(produtos);
            }
        
            return listagem;
            
        } 
        catch (Exception e) 
        {
            return null;
        }
                
    }
    
      
        
}
