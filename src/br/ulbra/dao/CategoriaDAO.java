/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;

import br.ulbra.classes.Categoria;
import br.ulbra.classes.Marca;
import br.ulbra.classes.Sala;
import br.ulbra.classes.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jeferson Leon
 */
public class CategoriaDAO {

    Connection con;

    public CategoriaDAO() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

//MÉTODO CRIADO PARA INSERIR USUÁRIO NO BANCO DE DADOS
    public void create(Categoria c) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbcategoria (categoria) VALUES (?)");

            stmt.setString(1, c.getCategoria());
          
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Categoria Salva com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

// MÉTODO CRIADO PARA EXCLUIR DO BANCO DE DADOS
    public void delete(Categoria c) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbcategoria WHERE pkidcategoria = ?");
            stmt.setInt(1, c.getIdPkCat());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Categoria Excluida com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODO CRIADO PARA MODIFICAR NO BANCO DE DADOS
    public void update(Categoria c) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbcategoria SET categoria = ? WHERE pkidcategoria = ?");
            stmt.setString(1, c.getCategoria());
            

            stmt.setInt(2, c.getIdPkCat());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Categoria Atualizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODOS CRIADOS PARA FAZER PESQUISAS NO BANCO DE DADOS
//EM ORDEM DE CADASTRO TODOS
    public ArrayList<Categoria> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Categoria> categorias = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbcategoria");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Categoria categoria = new Categoria();

                categoria.setIdPkCat(rs.getInt("pkidcategoria"));
                categoria.setCategoria(rs.getString("categoria"));
                
                categorias.add(categoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return (ArrayList<Categoria>) categorias;

    }

//PESQUISA PELO LOGIN
    public ArrayList<Categoria> readForDesc(String desc, int opcao) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null; int tipo = 0;
        if(opcao == 1){
            sql = "SELECT * FROM tbcategoria ORDER BY categoria ASC";
        }else if(opcao == 2){
             sql = "SELECT * FROM tbcategoria ORDER BY categoria DESC";
        }else {
           sql = "SELECT * FROM tbcategoria WHERE categoria LIKE ?";
           tipo=1;
        }
        
        
        ArrayList<Categoria> categorias = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
          
            if (tipo==1 || tipo ==2){
                stmt.setString(1, "%" + desc + "%");                
            }
            rs = stmt.executeQuery();

            while (rs.next()) {

                Categoria categoria = new Categoria();

                categoria.setIdPkCat(rs.getInt("pkidcategoria"));
                categoria.setCategoria(rs.getString("categoria"));
                categorias.add(categoria);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return categorias;
    }

    
}
