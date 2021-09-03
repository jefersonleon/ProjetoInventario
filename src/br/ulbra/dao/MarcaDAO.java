/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.dao;

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
public class MarcaDAO {

    Connection con;

    public MarcaDAO() throws SQLException {
        con = ConnectionFactory.getConnection();
    }

//MÉTODO CRIADO PARA INSERIR USUÁRIO NO BANCO DE DADOS
    public void create(Marca m) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO tbmarca (marca) VALUES (?)");

            stmt.setString(1, m.getMarca());
          
            
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Marca Salva com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

// MÉTODO CRIADO PARA EXCLUIR DO BANCO DE DADOS
    public void delete(Marca m) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM tbmarca WHERE pkidmarca = ?");
            stmt.setInt(1, m.getIdPkMarca());
            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Marca Excluida com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODO CRIADO PARA MODIFICAR NO BANCO DE DADOS
    public void update(Marca m) {

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE tbmarca SET marca = ? WHERE pkidmarca = ?");
            stmt.setString(1, m.getMarca());
            

            stmt.setInt(2, m.getIdPkMarca());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Marca Atualizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

//MÉTODOS CRIADOS PARA FAZER PESQUISAS NO BANCO DE DADOS
//EM ORDEM DE CADASTRO TODOS
    public ArrayList<Marca> read() {

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Marca> marcas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tbmarca");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Marca marca = new Marca();

                marca.setIdPkMarca(rs.getInt("pkidmarca"));
                marca.setMarca(rs.getString("marca"));
                
                marcas.add(marca);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return (ArrayList<Marca>) marcas;

    }

//PESQUISA PELO LOGIN
    public ArrayList<Marca> readForDesc(String desc, int opcao) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = null; int tipo = 0;
        if(opcao == 1){
            sql = "SELECT * FROM tbmarca ORDER BY marca ASC";
        }else if(opcao == 2){
             sql = "SELECT * FROM tbmarca ORDER BY marca DESC";
        }else {
           sql = "SELECT * FROM tbmarca WHERE marca LIKE ?";
           tipo=1;
        }
        
        
        ArrayList<Marca> marcas = new ArrayList<>();

        try {
            stmt = con.prepareStatement(sql);
          
            if (tipo==1 || tipo ==2){
                stmt.setString(1, "%" + desc + "%");                
            }
            rs = stmt.executeQuery();

            while (rs.next()) {

                Marca marca = new Marca();

                marca.setIdPkMarca(rs.getInt("pkidmarca"));
                marca.setMarca(rs.getString("marca"));
                marcas.add(marca);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MarcaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return marcas;
    }

    
}
